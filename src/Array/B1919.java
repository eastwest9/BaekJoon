package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        String str = br.readLine();
        String compare = br.readLine();

        int[] cntstr1 = new int[26];
        int[] cntstr2 = new int[26];

        for (int i = 0; i<str.length(); i++){
            cntstr1[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i<compare.length(); i++){
            cntstr2[compare.charAt(i) - 'a']++;
        }

        for (int i = 0; i<26; i++){
            int chk = cntstr1[i] - cntstr2[i];
            if(chk != 0){
                cnt += Math.abs(chk);
            }
        }


        System.out.println(cnt);
        br.close();
    }
}
