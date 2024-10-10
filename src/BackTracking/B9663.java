package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663 {
    static int N;
    static int cnt = 0;
    static boolean[] used1;
    static boolean[] used2;
    static boolean[] used3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        used1 = new boolean[40];
        used2 = new boolean[40];
        used3 = new boolean[40];

        bt(0);
        System.out.println(cnt);

    }
    static void bt(int k){
        if (k == N){
            cnt++;
            return;
        }
        for (int i = 0; i<N; i++){
            if (used1[i] || used2[i+k] || used3[k-i + N -1]){
                continue;
            }
            used1[i] = true;
            used2[i+k] = true;
            used3[k-i+N-1] = true;
            bt(k+1);
            used1[i] = false;
            used2[i+k] = false;
            used3[k-i+N-1] = false;
        }
    }
}
