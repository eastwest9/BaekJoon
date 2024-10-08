package Stack;

import java.io.*;
import java.util.Stack;

public class B4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;

        while (true){
            s = br.readLine();
            if(s.equals(".")){
                break;
            }

            bw.write(checkedString(s)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    public static String checkedString (String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c == '(' || c == '['){
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty() || stack.peek() != '('){
                    return "no";
                }else{
                    stack.pop();
                }
            }else if(c == ']'){
                if (stack.empty() || stack.peek() != '['){
                    return "no";
                }else {
                    stack.pop();
                }
            }
        }
        if (!stack.empty()){
            return "no";
        }
        return "yes";
    }
}
