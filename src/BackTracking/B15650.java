package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650 {
    static int N,M;
    static int[] list;
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[10];
        chk = new boolean[10];
        bt(1,0);


    }
    static void bt(int k, int d){
        if (d == M){
            for (int i = 0; i<M; i++){
                System.out.print(list[i] + " ");

            }
            System.out.println();
            return;
        }
        for (int i = k; i<=N; i++){
            if (!chk[i]){
                list[d] = i;
                chk[i] = true;
                bt(i+1, d+1);
                chk[i] = false;
            }
        }
    }
}
