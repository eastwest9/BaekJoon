package Queue;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)){
                    return Math.abs(o1) - Math.abs(o2);
                }else if(Math.abs(o1) == Math.abs(o2)){
                    return o1 - o2;
                }else{
                    return -1;
                }
            }
        });

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
