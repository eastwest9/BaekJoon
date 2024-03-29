package DFS;

import java.util.Scanner;

public class B2023 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);

    }
    // dfs 구현
    static void dfs(int number, int su){
        if(su == N){
            if(isPrime(number)){
                System.out.println(number);
            }
            return;
        }
        for(int i = 1; i< 10;i++){
            if(i%2 == 0){
                continue;
            }
            if(isPrime(number *10+i)){
                dfs(number*10+i,su+1);
            }

        }
    }
    // 소수 찾기 함수
    static boolean isPrime(int number){
        for(int i = 2;i<= number/2; i++){
            if(number % i ==0){
                return false;
            }
        }
        return true;
    }
}
