package Greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for(int i = 0; i<N;i++){
            int tmp = sc.nextInt();
            if(tmp == 1){
                ++one;
            } else if (tmp == 0) {
                ++zero;
            } else if (tmp < 0) {
                minusPq.add(tmp);
            } else {
                plusPq.add(tmp);
            }
        }

        int sum = 0;
        while (plusPq.size() > 1){
            int plus1 = plusPq.remove();
            int plus2 = plusPq.remove();
            sum += (plus1*plus2);
        }
        if (!plusPq.isEmpty()){
            sum += plusPq.remove();
        }

        while(minusPq.size() > 1){
            int num1 = minusPq.remove();
            int num2 = minusPq.remove();
            sum += (num1 * num2);
        }
        if (!minusPq.isEmpty()){
            if(zero == 0){
                sum+= minusPq.remove();
            }
        }
        sum += one;
        System.out.println(sum);
    }

}
