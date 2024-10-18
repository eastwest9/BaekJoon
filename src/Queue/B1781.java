package Queue;

import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Long, Long> hm = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][2];
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] p : list){
            int d = p[0];
            int r = p[1];

            pq.add(r);
            if (pq.size() > d){
                pq.poll();
            }
        }
        int ans = 0;
        while (!pq.isEmpty()){
            ans += pq.poll();
        }
        System.out.println(ans);
    }
}
