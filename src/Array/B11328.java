package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 입력 받은 값 정렬시켜서 비교
public class B11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String [] answer = new String[N];

        for(int i = 0; i<N ; i++){
            String s = br.readLine();
            String [] arr = s.split(" ");
            char[] chArr = arr[0].toCharArray();
            char[] chArr2 = arr[1].toCharArray();
            Arrays.sort(chArr);
            Arrays.sort(chArr2);

            String str = new String(chArr);
            String compare = new String(chArr2);

            if (str.equals(compare)) {
                answer[i] = "Possible";

            }else{
                answer[i] = "Impossible";
            }
        }
        for(int i = 0; i< answer.length; i++) {
            System.out.println(answer[i]);
        }
        br.close();
    }
}
