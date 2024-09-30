package Stack;

import java.io.*;
import java.util.Stack;

public class B9012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i++){
            String[] s = br.readLine().split("");
            checkedVPS(s);
            bw.write(checkedVPS(s) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static String checkedVPS(String[] s){
        Stack<String> stack = new Stack<>();
        for(int j = 0; j<s.length; j++){
            if(s[j].equals("(")){
                stack.add("(");
            }else {
                if(stack.isEmpty()){
                    return "NO";
                }else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            return "NO";
        }
        return "YES";
    }
}
