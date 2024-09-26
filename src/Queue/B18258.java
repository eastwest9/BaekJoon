package Queue;

import java.io.*;
import java.util.*;

public class B18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();

        for(int i = 0 ; i<N ; i++){
            String[] arr = br.readLine().split(" ");
            String order = arr[0];
            if (order.equals("push")){
                q.add(Integer.parseInt(arr[1]));
            } else if (order.equals("pop")) {
                if (q.isEmpty()){
                    bw.write("-1\n");
                }else{
                    bw.write(q.poll() + "\n");
                }
            } else if (order.equals("size")) {
                bw.write(q.size() + "\n");
            } else if (order.equals("empty")) {
                if (q.isEmpty()){
                    bw.write("1\n");
                }else {
                    bw.write("0\n");
                }
            } else if (order.equals("front")) {
                if (q.isEmpty()){
                    bw.write("-1\n");
                }else {
                    bw.write(q.peek() +"\n");
                }
            } else if (order.equals("back")) {
                if (q.isEmpty()){
                    bw.write("-1\n");
                }else {
                    bw.write(q.peekLast() +"\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
