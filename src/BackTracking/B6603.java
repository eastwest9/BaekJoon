package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class B6603 {
    static int[] list;
    static int[] ans;
    static int K;
    static boolean[] chk;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            K = Integer.parseInt(st.nextToken());
            if (K == 0){
                break;
            }

            chk = new boolean[K];
            list = new int[K];
            for (int i = 0; i<K; i++){
                list[i] = Integer.parseInt(st.nextToken());
            }

            ans = new int[6];
            dfs(0, 0);
            System.out.println();
        }

    }
    static void dfs(int x, int s){
        if (x == 6){
            for (int val : ans){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for (int i = s; i<K; i++){
            if (!chk[i]){
                chk[i] = true;
                ans[x] = list[i];
                dfs(x+1, i);
                chk[i] = false;
            }
        }
    }
}
