package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Stack;

public class B2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int val = 1;
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.add(s.charAt(i));
                val *= 2;
            } else if (s.charAt(i) == '[') {
                stack.add(s.charAt(i));
                val *= 3;
            } else if (s.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '('){
                    cnt = 0;
                    break;
                }else if(s.charAt(i-1) == '('){
                    cnt += val;
                }
                stack.pop();
                val /= 2;
            }else if (s.charAt(i) == ']'){
                if (stack.isEmpty() || stack.peek() != '['){
                    cnt = 0;
                    break;
                }else if(s.charAt(i-1) == '['){
                    cnt += val;
                }
                stack.pop();
                val /= 3;
            }
        }
        if (!stack.isEmpty()){
            System.out.println("0");
        }else {
            System.out.println(cnt);
        }

        br.close();
    }
}
