package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] day = new int[N+1];
        int[] pay = new int[N+1];

        int[] d = new int[N+1];

        for (int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            day[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i<N; i++){
            if (day[i]+i <= N){
                d[i+day[i]] = Math.max(d[i+ day[i]], d[i] + pay[i]);
            }
            d[i+1] = Math.max(d[i+1],d[i]);
        }
        System.out.println(d[N]);
    }
}
