package Greedy;


import java.util.Scanner;

public class B11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coin = new int[N];
        int answer = 0;
        for(int i = 0; i<N; i++){
            coin[i] = sc.nextInt();
        }

        for(int i = N-1; i >= 0; i--){
            int tmp = coin[i];
            if(tmp<= K){
                answer += K/tmp;
                K = K%tmp;
            }
        }
        System.out.println(answer);
    }
}
