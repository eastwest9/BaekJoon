package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2178 {
    static int N,M;
    static int[][] board;
    static boolean[][] check;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N= Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        board = new int[N][M];

        for(int i = 0; i<N; i++){
            String[] arr = br.readLine().split("");
            for(int j = 0; j<M; j++){
                board[i][j] = Integer.parseInt(arr[j]);
            }
        }

        check = new boolean[N][M];
        check[0][0] =true;
        bfs(0,0);

        System.out.println(board[N-1][M-1]);
        br.close();
    }
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while (!q.isEmpty()){
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];
            for(int dir = 0; dir<4; dir++){
                int nx = px + dx[dir];
                int ny = py + dy[dir];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (check[nx][ny] || board[nx][ny] == 0) continue;
                q.add(new int[] {nx,ny});
                board[nx][ny] = board[px][py] + 1;
                check[nx][ny] = true;
            }
        }
    }
}
