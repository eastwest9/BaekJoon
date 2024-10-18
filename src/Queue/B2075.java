package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j<N; j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i<N; i++){
            int x = pq.poll();
            if(i == N-1){
                System.out.println(x);
            }
        }
    }
}
