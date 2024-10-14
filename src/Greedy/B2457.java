package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.Flow;

public class B2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // flower 구현체 만들어서 해야함

        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];

        StringTokenizer st;
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            int start = sm * 100 + sd;
            int end = em * 100 + ed;
            flowers[i] = new Flower(start, end);

        }
        Arrays.parallelSort(flowers);
        int endDay = 1201;
        int start = 301;
        int cnt = 0;
        int max = 0;
        int idx = 0;

        while (start < endDay){
            boolean isFind = false;

            for (int i = idx; i<N; i++){
                if (flowers[i].start > start){
                    break;
                }

                if (max < flowers[i].end) {
                    isFind = true;
                    max = flowers[i].end;
                    idx = i + 1;
                }
            }
            if (isFind){
                start = max;
                cnt++;
            }else {
                break;
            }
        }
        if (max < endDay){
            System.out.println(0);
        }else {
            System.out.println(cnt);
        }
    }
}
class Flower implements Comparable<Flower>{
    int start;
    int end;

    Flower(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Flower f){
        if (this.start < f.start){
            return -1;
        }
        else if (this.start == f.start){
            if (this.end > f.end){
                return -1;
            } else if (this.end == f.end) {
                return 0;
            }
            return 1;
        }
        else {
            return 1;
        }
    }
}