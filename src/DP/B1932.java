package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] tree = new int[n+1][n+1];
        int[][] max = new int[n+1][n+1];

        StringTokenizer st;
        for (int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j<=i; j++){
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=n; j++){
                max[i][j] = Math.max(max[i-1][j-1], max[i-1][j]) + tree[i][j];
            }
        }
        int answer = 0;
        for (int i = 1; i<=n; i++){
            if (max[n][i] > answer){
                answer = max[n][i];
            }
        }
        System.out.println(answer);
    }
}
