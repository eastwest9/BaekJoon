package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int[] list = new int[A+1];
        int[] d = new int[A+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i<=A; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i<=A; i++){
            d[i] = list[i];
            for (int j = 1; j<i; j++){
                if (list[i] > list[j]){
                    d[i] = Math.max(d[j] + list[i], d[i]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i : d){
            max = Math.max(i,max);
        }
        System.out.println(max);
        br.close();
    }
}
