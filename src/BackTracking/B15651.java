package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15651 {
    static int N,M;
    static int[] list;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[10];
        sb = new StringBuilder();
        dfs(0);
        System.out.print(sb);
    }
    static void dfs(int x){
        if (x == M){
            for (int i = 0; i<M; i++){
                sb.append(list[i]).append(" ");
            }
           sb.append("\n");
            return;
        }
        for (int i = 1; i<=N; i++){
            list[x] = i;
            dfs(x+1);
        }
    }
}
