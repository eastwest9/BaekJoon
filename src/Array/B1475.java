package Array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B1475 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = sc.nextInt();
        int max = 0;

        int [] nlist = new int[10];

        String [] list = Integer.toString(N).split("");
        for(int i =0; i<list.length ; i++){
            for(int j = 0; j<10; j++){
                if(Integer.parseInt(list[i]) == j){
                    nlist[j]++;
                }
                nlist[Integer.parseInt(list[i])]++;
            }
        }
        int sn = (nlist[6] + nlist[9]) / 2 + (nlist[6] + nlist[9]) % 2;

        nlist[6] = 0;
        nlist[9] = 0;
        for(int i = 0; i<nlist.length; i++){
            if(max < nlist[i]){
                max = nlist[i];
            }
        }
        if(max < sn){
            max = sn;
        }

        System.out.println(max);

        br.close();
    }
}
