package Array;
import java.util.Arrays;
import java.util.Scanner;

public class B10808 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();

        int [] answer = new int[26];
        for(int i = 0; i< S.length(); i++) {
            char c = S.charAt(i);
            answer[c - 'a']++;
        }

        for(int i = 0; i<answer.length; i++){
            System.out.printf(answer[i]+ " ");
        }

    }
}
