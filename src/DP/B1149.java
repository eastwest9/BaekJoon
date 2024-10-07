package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] d = new int[N+1][3];
        int[] r = new int[N+1];
        int[] g = new int[N+1];
        int[] b = new int[N+1];
        for (int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine()," ");
            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        d[1][0] = r[1];
        d[1][1] = g[1];
        d[1][2] = b[1];

        for (int i = 2; i<=N; i++){
            d[i][0] = Math.min(d[i-1][1],d[i-1][2]) + r[i];
            d[i][1] = Math.min(d[i-1][0],d[i-1][2]) + g[i];
            d[i][2] = Math.min(d[i-1][0],d[i-1][1]) + b[i];
        }
        int answer = Math.min(d[N][2],(Math.min(d[N][0],d[N][1])));

        System.out.println(answer);
    }
}
