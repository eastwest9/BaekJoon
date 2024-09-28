package Deque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class B5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i++){
            String[] arr = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(),"[],");

            Deque<Integer> d = new ArrayDeque<>();
            for(int j = 0; j<n; j++){
                d.add(Integer.parseInt(st.nextToken()));
            }
            bw.write(printAnswer(d,arr) + "\n");

        }


        bw.flush();
        bw.close();
        br.close();
    }
    static String printAnswer(Deque<Integer> d, String[] command){
        boolean reverse = false;

        for(int i = 0; i< command.length; i++){
            if(command[i].equals("R")){
                reverse = !reverse;
            } else if (command[i].equals("D")) {
                if(d.size() == 0){
                    return "error";
                }
                if(reverse){
                    d.pollLast();
                }else{
                    d.pollFirst();
                }
            }
        }
        StringBuilder sb = new StringBuilder("[");
        while (!d.isEmpty()){
            sb.append(reverse ? d.removeLast() : d.removeFirst());
            if (d.size() != 0){
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
