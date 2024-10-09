package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i<=N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        int[] d = new int[N+1];


        int max = Integer.MIN_VALUE;
        for (int i = 1; i<=N; i++){
            d[i] = Math.max(d[i-1] + list[i], list[i]);
            max = Math.max(max, d[i]);
        }

        System.out.println(max);
    }
}
