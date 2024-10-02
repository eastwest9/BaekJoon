package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {
    static int N,K;
    static int[] dist;
    static int[] dx = {-1,1,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[100001];
        Arrays.fill(dist, -1);
        dist[N] = 0;

        System.out.println(bfs(N));
        br.close();
    }
    static int bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()){
            int p = q.poll();
            for(int i = 0; i<3; i++){
                int nx;
                if(dx[i] == 2){
                    nx = p * dx[i];
                }else {
                    nx = p + dx[i];
                }
                if(nx < 0 || nx > 100000) continue;
                if(dist[nx] != -1) continue;
                dist[nx] = dist[p] + 1;
                q.add(nx);
            }
        }
        return dist[K];
    }
}
