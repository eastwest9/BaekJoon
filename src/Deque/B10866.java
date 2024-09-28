package Deque;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class B10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> d = new LinkedList<>();
        
        for(int i = 0; i < N; i++){
            String[] arr = br.readLine().split(" ");
            String order = arr[0];
            
            if(order.equals("push_front")){
                d.addFirst(Integer.parseInt(arr[1]));
            } else if (order.equals("push_back")) {
                d.addLast(Integer.parseInt(arr[1]));
            } else if (order.equals("pop_front")) {
                if(d.isEmpty()){
                    bw.write("-1\n");
                }else{
                    bw.write(d.pollFirst() +"\n");
                }
            } else if (order.equals("pop_back")) {
                if (d.isEmpty()){
                    bw.write("-1\n");
                } else {
                    bw.write(d.pollLast() +"\n");
                }
            } else if (order.equals("size")) {
                bw.write(d.size()+ "\n");
            } else if (order.equals("empty")) {
                if(d.isEmpty()){
                    bw.write("1\n");
                }else{
                    bw.write("0\n");
                }
            } else if (order.equals("front")){
                if (d.isEmpty()){
                    bw.write("-1\n");
                }else {
                    bw.write(d.getFirst()+"\n");
                }
            } else if (order.equals("back")) {
                if (d.isEmpty()){
                    bw.write("-1\n");
                }else {
                    bw.write(d.getLast() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
