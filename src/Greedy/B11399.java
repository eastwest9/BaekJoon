package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int ans = 0;
        int[] arr = new int[N+1];
        for (int i = 1; i<=N; i++){
            arr[i] = list[i-1] + arr[i-1];
            ans += arr[i];
        }
        System.out.println(ans);

    }
}
