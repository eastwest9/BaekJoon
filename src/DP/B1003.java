package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] d = new int[41][2];
        d[0][0] = 1;
        d[0][1] = 0;
        d[1][0] = 0;
        d[1][1] = 1;
        for (int i = 2; i<=40; i++){
            d[i][0] = d[i-1][1];
            d[i][1] = d[i-1][0] + d[i-1][1];
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            sb.append(d[N][0]).append(" ").append(d[N][1]).append("\n");
        }
        System.out.println(sb);
    }
}
