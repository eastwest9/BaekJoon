package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] table = new int[N][2];
        for(int i = 0 ; i<N;i++){
            table[i][0] = sc.nextInt();
            table[i][1] = sc.nextInt();
        }
        Arrays.sort(table, new Comparator<int[]>(){ // compare() 함수 재정의
            @Override
            public int compare(int[] s, int[] e){
                if(s[1] == e[1]){
                    return s[0] - e[0];
                }
                return s[1] - e[1];
            }
        });
        int cnt = 0;
        int end = -1;
        for(int i = 0; i<N;i++){
            if(table[i][0] >= end){
                end = table[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
