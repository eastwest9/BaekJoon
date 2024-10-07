package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5427 {
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N, M;
    static Queue<int[]> fq = new LinkedList<>();
    static Queue<int[]> hq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            fq.clear();  // 불 큐 초기화
            hq.clear();  // 사람 큐 초기화
            int[][] fireVisited = new int[N][M]; // 불 방문 시간 기록
            int[][] humanVisited = new int[N][M]; // 사람 방문 시간 기록

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = s.charAt(j);
                    fireVisited[i][j] = -1;  // 방문하지 않음을 -1로 초기화
                    humanVisited[i][j] = -1; // 방문하지 않음을 -1로 초기화
                    if (map[i][j] == '*') {
                        fq.add(new int[]{i, j});
                        fireVisited[i][j] = 0;  // 불이 퍼진 시간 초기화
                    }
                    if (map[i][j] == '@') {
                        hq.add(new int[]{i, j});
                        humanVisited[i][j] = 0; // 사람이 시작한 시간 초기화
                    }
                }
            }

            // 먼저 불을 BFS로 퍼뜨립니다.
            spreadFire(fireVisited);

            // 사람의 이동을 BFS로 처리하며 탈출할 수 있는지 확인합니다.
            int answer = moveHuman(humanVisited, fireVisited);

            if (answer == -1) {
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void spreadFire(int[][] fireVisited) {
        while (!fq.isEmpty()) {
            int[] p = fq.poll();
            int px = p[0];
            int py = p[1];

            for (int j = 0; j < 4; j++) {
                int nx = px + dx[j];
                int ny = py + dy[j];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (fireVisited[nx][ny] == -1 && map[nx][ny] == '.') {
                    fireVisited[nx][ny] = fireVisited[px][py] + 1;  // 불이 퍼지는 시간 기록
                    fq.add(new int[]{nx, ny});
                }
            }
        }
    }

    static int moveHuman(int[][] humanVisited, int[][] fireVisited) {
        while (!hq.isEmpty()) {
            int[] p = hq.poll();
            int px = p[0];
            int py = p[1];

            for (int j = 0; j < 4; j++) {
                int nx = px + dx[j];
                int ny = py + dy[j];

                // 사람이 경계를 벗어나면 탈출 성공
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    return humanVisited[px][py] + 1;
                }

                // 사람이 이동할 수 있는 조건: 이동할 곳이 빈 공간이고,
                // 불이 퍼지기 전이어야 하며, 아직 사람이 방문하지 않은 곳이어야 함
                if (map[nx][ny] == '.' && humanVisited[nx][ny] == -1) {
                    if (fireVisited[nx][ny] == -1 || fireVisited[nx][ny] > humanVisited[px][py] + 1) {
                        humanVisited[nx][ny] = humanVisited[px][py] + 1;
                        hq.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;  // 탈출 불가능
    }
}
