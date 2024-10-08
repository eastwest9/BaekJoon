package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] d = new int[1000001];
        int[] tmp = new int[1000001];
        d[1] = 0;
        for (int i = 2; i<=N; i++){
            d[i] = d[i-1] + 1;
            tmp[i] = i-1;
            if (i%2 == 0 && d[i] > d[i/2] + 1){
                d[i] = d[i/2] + 1;
                tmp[i] = i/2;
            }
            if (i%3 == 0 && d[i] > d[i/3] + 1){
                d[i] = d[i/3] + 1;
                tmp[i] = i/3;
            }
        }
        System.out.println(d[N]);
        StringBuilder sb = new StringBuilder();
        while (N>0){
            sb.append(N).append(" ");
            N = tmp[N];
        }
        System.out.println(sb);

    }
}
