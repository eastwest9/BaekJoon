package Array;

import java.util.Scanner;

public class B10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] list = new int[N];
        for(int i = 0; i<N; i++){
            list[i] = sc.nextInt();
        }
        int v = sc.nextInt();
        int answer = 0;
        for(int i = 0; i<list.length; i++){
            if(v == list[i]){
                answer++;
            }
        }
        System.out.println(answer);


    }
}
