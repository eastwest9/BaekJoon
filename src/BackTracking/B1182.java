package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182 {
    static int N,S;
    static int[] list;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        list = new int[30];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        bt(0,0);
        if (S == 0){
            cnt--;
        }
        System.out.println(cnt);

    }
    static void bt(int k, int t){
        if (k == N){
            if (t == S){
                cnt++;
            }
            return;
        }
        bt(k+1, t);
        bt(k+1, t+list[k]);
    }
}
