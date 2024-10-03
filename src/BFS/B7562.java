package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {
    static int[][] board;
    static int N;
    static boolean[][] check;
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            check = new boolean[N][N];

            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bfs(x,y);
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(board[n][m]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
    static void bfs(int x, int y){
        q.add(new int[] {x,y});
        check[x][y] = true;
        while (!q.isEmpty()){
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];
            for(int i = 0; i<8; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(check[nx][ny]) continue;
                q.add(new int[] {nx, ny});
                board[nx][ny] = board[px][py] + 1;
                check[nx][ny] = true;
            }
        }
    }
}
