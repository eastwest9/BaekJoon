package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759 {
    static int L,C;
    static char[] list;
    static char[] arr;
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        list = new char[C];
        arr = new char[C];
        chk = new boolean[C];
        String s = br.readLine().replaceAll(" ","");
        for (int i = 0; i<C; i++){
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr);
        dfs(0,0);
    }
    static void dfs(int d, int s){
        if (d == L){
            int a = 0;
            int b = 0;
            String st = "";
            for (int i = 0; i<L; i++){
                char c = list[i];
                st += c;
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    a++;
                }else {
                    b++;
                }
            }
            if (a >= 1 && b >= 2){
                System.out.println(st);
            }
            return;
        }
        for (int i = s; i<C; i++){
            if (!chk[i]){
                chk[i] = true;
                list[d] = arr[i];
                dfs(d+1, i);
                chk[i] = false;
            }
        }
    }
}
