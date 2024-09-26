package Queue;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class B2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> d = new LinkedList<>();

        for(int i = 1 ; i<= N ;i++){
            d.add(i);
        }
        while(d.size() > 1){
            d.poll();
            d.addLast(d.poll());
        }
        bw.write(d.poll()+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
