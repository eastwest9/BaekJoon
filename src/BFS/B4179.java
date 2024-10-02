package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B4179 {
    static int R,C;
    static char[][] map;
    static int[][] fire;
    static int[][] human;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<int[]> q1 = new LinkedList<>(); // fire
    static Queue<int[]> q2 = new LinkedList<>(); // size
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        human = new int[R][C];
        fire = new int[R][C];
        for(int i = 0; i<R; i++){
            String s = br.readLine();
            for (int j = 0; j<C; j++){
                map[i][j] = s.charAt(j);
                fire[i][j] = -1;
                human[i][j] = -1;
                if (map[i][j] == 'F'){
                    q1.add(new int[] {i,j});
                    fire[i][j] = 0;
                }
                if (map[i][j] == 'J'){
                    q2.add(new int[] {i,j});
                    human[i][j] = 0;
                }
            }
        }
        bfs();
        br.close();
    }
    static void bfs(){
        while (!q1.isEmpty()){
            int[] p = q1.poll();
            int px = p[0];
            int py = p[1];
            for(int i = 0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (fire[nx][ny] >= 0 || map[nx][ny] == '#') continue;
                fire[nx][ny] = fire[px][py] + 1;
                q1.add(new int[] {nx, ny});
            }
        }
        while (!q2.isEmpty()){
            int[] p = q2.poll();
            int px = p[0];
            int py = p[1];
            for(int i = 0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    System.out.println(human[px][py] + 1);
                    return;
                }
                if (human[nx][ny] >= 0 || map[nx][ny] == '#') continue;
                if (fire[nx][ny] != -1 && fire[nx][ny] <= human[px][py] + 1) continue;
                human[nx][ny] = human[px][py] + 1;
                q2.add(new int[] {nx, ny});
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
