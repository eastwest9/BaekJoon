package Queue;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i<N; i++){
            int x = Integer.parseInt(br.readLine());

            if (maxPq.size() == minPq.size()){
                maxPq.add(x);

                if (!minPq.isEmpty() && maxPq.peek() > minPq.peek()){
                    minPq.add(maxPq.poll());
                    maxPq.add(minPq.poll());
                }
            }else{
                minPq.add(x);
                if (maxPq.peek() > minPq.peek()){
                    minPq.add(maxPq.poll());
                    maxPq.add(minPq.poll());
                }
            }
            bw.write(maxPq.peek()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
