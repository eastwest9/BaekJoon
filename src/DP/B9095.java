package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] d = new int[12];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int i = 4; i<12; i++){
            d[i] = d[i-3] + d[i-2] + d[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            sb.append(d[n]).append("\n");
        }
        System.out.println(sb);
    }
}
