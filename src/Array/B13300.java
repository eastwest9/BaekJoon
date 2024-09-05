package Array;


import java.util.Scanner;

public class B13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int [] wlist = new int[6];
        int [] mlist = new int[6];

        int answer = 0;

        for (int i = 0; i<N; i++){
            int s = sc.nextInt();
            int y = sc.nextInt();
            if(s == 0){
                wlist[y-1]++;
            }
            else{
                mlist[y-1]++;
            }
        }

        for(int i = 0; i<6; i++){
            double a = Math.ceil((float)wlist[i]/K);
            double b = Math.ceil((float)mlist[i]/K);
            answer += (int)a;
            answer += (int)b;
        }
        System.out.println(answer);
    }
}
