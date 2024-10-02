package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1012 {
    static int N,M,K;
    static int[][] board;
    static boolean[][] check;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T; t++){
            String[] arr1 = br.readLine().split(" ");
            N = Integer.parseInt(arr1[0]);
            M = Integer.parseInt(arr1[1]);
            K = Integer.parseInt(arr1[2]);
            board = new int[N][M];
            check = new boolean[N][M];
            int cnt = 0;
            for(int i = 0; i<K; i++){
                String[] arr2 = br.readLine().split(" ");
                int n = Integer.parseInt(arr2[0]);
                int m = Integer.parseInt(arr2[1]);
                board[n][m] = 1;
            }
            for (int i = 0; i<N; i++){
                for (int j = 0; j<M; j++){
                    if (board[i][j] == 1 && !check[i][j]){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    static void bfs(int x, int y){
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
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (check[nx][ny] || board[nx][ny] != 1) continue;
                q.add(new int[] {nx,ny});
                check[nx][ny] = true;
            }
        }
    }
}
