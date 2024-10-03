package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569 {
    static int N,M,H;
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static int[][][] box;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];

        for (int i = 0; i<H; i++){
            for (int j = 0; j<N; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k<M; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1){
                        q.add(new int[] {i,j,k});
                    }
                }
            }
        }
        System.out.println(bfs());
        br.close();
    }
    static int bfs(){
        while (!q.isEmpty()){
            int[] p = q.poll();
            int pz = p[0];
            int px = p[1];
            int py = p[2];
            for (int i = 0; i<6; i++){
                int nz = pz + dz[i];
                int nx = px + dx[i];
                int ny = py + dy[i];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
                if (box[nz][nx][ny] == 0){
                    box[nz][nx][ny] = box[pz][px][py] + 1;
                    q.add(new int[] {nz,nx,ny});
                }
            }
        }
        int max = Integer.MIN_VALUE;

        if (checkZero()){
            return -1;
        }else {
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k<M; k++){
                        max = Math.max(max, box[i][j][k]);
                    }
                }
            }
            return max - 1;
        }
    }
    private static boolean checkZero() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k<M; k++){
                    if (box[i][j][k] == 0)
                        return true;
                }
            }
        }
        return false;
    }
}
