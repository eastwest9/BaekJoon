package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2468 {
    static int N;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];


        int max = Integer.MIN_VALUE;
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }
        int answer = 1;
        for (int h = 1; h<max; h++){
            int cnt = 0;
            check = new boolean[N][N];
            for (int i = 0; i<N; i++){
                for (int j = 0; j<N; j++){
                    if (map[i][j] > h && !check[i][j]){
                        bfs(i,j,h);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
        br.close();
    }
    static void bfs(int x, int y, int n){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        check[x][y] = true;

        while (!q.isEmpty()){
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];

            for (int i = 0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] > n && !check[nx][ny]){
                    q.add(new int[]{nx, ny});
                    check[nx][ny] = true;
                }
            }
        }
    }
}
