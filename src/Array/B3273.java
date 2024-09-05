package Array;

import java.util.Arrays;
import java.util.Scanner;

public class B3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] a = new int[n];
        for(int i = 0 ; i<n ; i++){
            a[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        Arrays.sort(a);
        int answer = 0;
        int left = 0;
        int right = a.length - 1;

        while (left < right){
            int sum = a[left] + a[right];
            if(sum == x){
                answer++;
                left++;
                right--;
            }else if(sum < x){
                left++;
            }else{
                right--;
            }
        }
        System.out.println(answer);
    }
}
