package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2583 {
    static int N,M;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new boolean[N][M];

        for (int k = 0; k<K; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for (int y = ly; y<ry; y++){
                for (int x = lx; x<rx; x++){
                    map[x][y] = 1;
                }
            }
        }
        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i<N; i++){
            for (int j = 0; j<M; j++){
                if (!check[i][j] && map[i][j] == 0){
                    int data = bfs(i,j);
                    list.add(data);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for (int i = 0; i< list.size(); i++){
            System.out.print(list.get(i) + " ");
        }

        br.close();
    }
    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        check[x][y] = true;
        int cnt = 1;

        while (!q.isEmpty()){
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];

            for (int i = 0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(check[nx][ny] || map[nx][ny] != 0) continue;
                q.add(new int[]{nx,ny});
                check[nx][ny] = true;
                cnt++;
            }
        }
        return cnt;
    }
}
