package Stack;

import java.io.*;
import java.util.Stack;

public class B3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            String s = br.readLine();
            if(checkedString(s)){
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();

    }

    public static boolean checkedString(String s){
        if (s.length() % 2 == 1){
            return false;
        }

        char c = s.charAt(0);
        Stack<Character> stack = new Stack<>();
        stack.add(c);

        for(int i = 1; i<s.length() ; i++){
            if(stack.size() > 0 && stack.peek() == s.charAt(i)){
                stack.pop();
            }else {
                stack.add(s.charAt(i));
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
/*
짝수만 가능
1. A일 경우
1-1 : 다음 값이 A
1-2 : 다음 값이 B -> B

기존 값과 같은 경우 OK
기존 값과 다른 경우 다음까지 확인 필요
 */