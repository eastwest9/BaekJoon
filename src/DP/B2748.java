package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] d = new long[91];
        d[0] = 0;
        d[1] = 1;
        d[2] = 1;
        d[3] = 2;
        for (int i = 4; i<d.length; i++){
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[N]);
    }
}
