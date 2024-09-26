package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int rear = 0;

        for(int i = 0 ; i<N ; i++){
            String s = br.readLine();
            String [] arr = s.split(" ");
            if (arr[0].equals("push")){
                rear = Integer.parseInt(arr[1]);
                q.add(rear);
            } else if (arr[0].equals("pop")) {
                if (q.isEmpty()){
                    System.out.println("-1");
                }else{
                    System.out.println(q.poll());
                }
            } else if (arr[0].equals("size")) {
                System.out.println(q.size());
            } else if (arr[0].equals("empty")) {
                if (q.isEmpty()){
                    System.out.println("1");
                }else {
                    System.out.println("0");
                }
            } else if (arr[0].equals("front")) {
                if (q.isEmpty()){
                    System.out.println("-1");
                }else {
                    System.out.println(q.peek());
                }
            } else if (arr[0].equals("back")) {
                if (q.isEmpty()){
                    System.out.println("-1");
                }else {
                    System.out.println(rear);
                }
            }
        }

    }
}
