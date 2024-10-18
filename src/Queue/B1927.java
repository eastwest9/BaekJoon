package Queue;

import java.io.*;
import java.util.PriorityQueue;

public class B1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if (x != 0){
                pq.add(x);
            }else{
                if (pq.isEmpty()){
                    bw.write("0\n");
                }else{
                    bw.write(pq.poll()+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
