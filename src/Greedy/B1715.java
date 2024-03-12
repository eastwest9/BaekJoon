package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B1715 {
    public static void main(String[] args) { // 우선순위 큐 사용
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> list = new PriorityQueue<>();

        for(int i = 0 ; i< N;i++ ){
         int a = sc.nextInt();
         list.add(a);
        }
        int card1 = 0;
        int card2 = 0;
        int sum = 0;
        while (list.size() != 1){
            card1 = list.poll();
            card2 = list.poll();
            sum += card1 + card2;
            list.add(card1 + card2);
        }
        System.out.println(sum);

    }
}
