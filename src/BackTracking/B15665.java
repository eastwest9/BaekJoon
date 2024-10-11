package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class B15665 {
    static int N,M;
    static int[] list = new int[10];
    static int[] arr;
    static boolean[] chk = new boolean[10];
    static LinkedHashSet<String> hs = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);
        hs.forEach(System.out::println);
    }
    static void dfs(int x, int k) {
        if (x == M){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i<M; i++){
                sb.append(list[i]).append(" ");
            }
            hs.add(sb.toString());
            return;
        }
        for (int i = k; i<N; i++){
            list[x] = arr[i];
            dfs(x+1, i);
        }
    }
}
