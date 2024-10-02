package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B10026 {
    static int N;
    static char[][] board;
    static boolean[][] check;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        check = new boolean[N][N];
        int cnt = 0;
        int rgcnt = 0;

        for (int i = 0; i<N; i++){
            String s = br.readLine();
            for (int j = 0; j<N; j++){
                board[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                if(!check[i][j]){
                    bfs(i,j, board[i][j]);
                    cnt++;
                }
            }
        }

        check = new boolean[N][N];
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                if(!check[i][j]){
                    bfs(i,j, board[i][j]);
                    rgcnt++;
                }
            }
        }

        System.out.println(cnt + " " +rgcnt);
        br.close();
    }
    static void bfs(int x, int y, char c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        check[x][y] = true;

        while (!q.isEmpty()){
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];
            for(int i = 0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (check[nx][ny] || board[nx][ny] != c) continue;
                q.add(new int[] {nx, ny});
                check[nx][ny] = true;
            }
            if(board[px][py] == 'G'){
                board[px][py] = 'R';
            }
        }
    }
}
