package Array;

import java.util.*;
public class B2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int m = A*B*C;
        int [] answer = new int[10];
        String [] list = Integer.toString(m).split("");

        for(int i = 0; i< list.length; i++){
            for(int j = 0; j<10; j++){
                if(Integer.parseInt(list[i]) == j){
                    answer[j]++;
                }
            }
        }
        for(int i = 0; i< answer.length; i++){
            System.out.println(answer[i]);
        }

    }
}
