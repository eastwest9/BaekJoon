package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[] list = new int[N];
        for(int i = 0; i<N; i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        for (int i = 0; i<N; i++){
            max = Math.max(max, list[i] *(N-i));
        }
        System.out.println(max);
        br.close();

    }
}
