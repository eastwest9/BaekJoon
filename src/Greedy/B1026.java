package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);

        int ans = 0;
        int b = N-1;
        for (int i = 0; i<N; i++){
            ans += (A[i] * B[b]);
            b--;
        }
        System.out.println(ans);
    }
}
