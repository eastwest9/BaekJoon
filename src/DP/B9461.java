package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        long[] d = new long[101];
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        d[4] = 2;
        d[5] = 2;
        for (int i = 6; i<=100; i++){
            d[i] = d[i-1] + d[i-5];
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            sb.append(d[N]).append("\n");
        }
        System.out.println(sb);
    }
}
