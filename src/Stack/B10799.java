package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Stack;

public class B10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int cnt = 0;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                stack.add('(');
            }
            else if (s.charAt(i) == ')'){
                stack.pop();
                if(s.charAt(i-1) == '('){
                    cnt += stack.size();
                } else if (s.charAt(i-1) == ')') {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
