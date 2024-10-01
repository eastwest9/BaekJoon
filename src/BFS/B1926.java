package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1926 {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] check;
    static int h,w;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        h = Integer.parseInt(arr[0]);
        w = Integer.parseInt(arr[1]);
        map = new int[h][w];

        for(int i = 0; i<h; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0; j<w; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        check = new boolean[h][w];
        int cnt = 0;
        int max = 0;
        for (int i = 0; i<h; i++){
            for (int j = 0; j<w; j++){
                if(map[i][j] == 1 && !check[i][j]){
                    max = Math.max(max, bfs(j,i));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
        br.close();
    }
    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        check[y][x] = true;
        int size = 1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];

            for (int d = 0; d<4; d++){
                int nx = px+dx[d];
                int ny = py+dy[d];
                if (nx < 0 || ny < 0 || nx > w-1 || ny > h-1){
                    continue;
                }
                if (check[ny][nx]){
                    continue;
                }
                if (map[ny][nx] == 1){
                    size++;
                    check[ny][nx] = true;
                    q.add(new int[] {nx,ny});
                }
            }
        }
        return size;
    }
}
