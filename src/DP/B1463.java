package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int [] d = new int[100001];
        for (int i = 2; i<=X; i++){
            d[i] = d[i-1]+1;
            if (i%2 == 0){
                d[i] = Math.min(d[i],d[i/2]+1);
            }
            if (i%3 == 0){
                d[i] = Math.min(d[i], d[i/3]+1);
            }
        }
        System.out.println(d[X]);
        br.close();
    }
}
