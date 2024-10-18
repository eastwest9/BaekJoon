package Queue;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i<N; i++){
                pq.add(Long.parseLong(st.nextToken()));
            }
            long sum = 0;

            while (!pq.isEmpty()){
                if (pq.size() == 1){
                    break;
                }
                long x = pq.poll();
                long y = pq.poll();
                long cal = x+y;
                pq.add(cal);
                sum += cal;
            }

            bw.write(sum+"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
