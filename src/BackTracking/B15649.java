package BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class B15649 {
    static int N,M;
    static int[] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[10];
        check = new boolean[10];
        bt(0);
        
        bw.flush();
        bw.close();
        br.close();
    }
    static void bt(int x){
        if (x == M){
            for (int i = 0; i<M; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i<=N; i++){
            if (!check[i]){
                arr[x] = i;
                check[i] = true;
                bt(x+1);
                check[i] = false;
            }
        }
    }
}
