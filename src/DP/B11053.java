package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] list = new int[A+1];
        int[] d = new int[A+1];

        for (int i = 1; i<=A; i++){
            list[i] = Integer.parseInt(st.nextToken());
            d[i] = 1;
        }

        int max = 1;
        for (int i = 1; i<=A; i++){
            for (int j = 1; j<i; j++){
                if (list[i] > list[j]){
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
            max = Math.max(max, d[i]);
        }
        System.out.println(max);

    }
}
