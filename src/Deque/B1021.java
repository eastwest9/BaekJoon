package Deque;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class B1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> d = new LinkedList<>();

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);

        int answer = 0;

        for(int i = 1; i<=N; i++){
            d.add(i);
        }
        String[] sel = br.readLine().split(" ");
        for(int i = 0; i<M; i++){
            int k = Integer.parseInt(sel[i]);

            int index = 0;
            for(int e : d) {
                if(e == k){
                    break;
                }
                index++;
            }
            if(index <= d.size()/2){
                while (d.peekFirst() != k){
                    d.addLast(d.pollFirst());
                    answer++;
                }
            } else {
                while (d.peekFirst() != k){
                    d.addFirst(d.pollLast());
                    answer++;
                }
            }
            d.pollFirst();
        }

        bw.write(answer +"");
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
 1 2 3 4 5 6 7 8 9 10  1
 2 3 4 5 6 7 8 9 10 1
 3 4 5 6 7 8 9 10 1     2
 1 3 4 5 6 7 8 9 10     3
 10 1 3 4 5 6 7 8 9     4
 9 10 1 3 4 5 6 7 8
 10 1 3 4 5 6 7 8       5
 8 10 1 3 4 5 6 7       6
 7 8 10 1 3 4 5 6       7
 6 7 8 10 1 3 4 5       8
 5 6 7 8 10 1 3 4


*/
