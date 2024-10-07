package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5014 {
    static int F,S,G,U,D;
    static int[] top;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        top = new int[F+1];
        for (int i = 1; i<=F; i++){
            top[i] = -1;
        }
        int cnt = bfs(S);

        if (cnt == -1){
            System.out.println("use the stairs");
        }else {
            System.out.println(cnt);
        }
        br.close();
    }
    static int bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        int[] dx = {U,-D};
        q.add(x);
        top[x] = 0;
        while (!q.isEmpty()){
            int px = q.poll();
            if(px == G){
                return top[px];
            }

            for (int i = 0; i<2; i++){
                int nx = px + dx[i];

                if (nx < 1 || nx > F) continue;
                if (top[nx] == -1){
                    top[nx] = top[px] + 1;
                    q.add(nx);
                }
            }
        }
        return -1;
    }
}
