package DFS;
import java.util.*;

// https://www.acmicpc.net/problem/11724
public class B11724 {
    static ArrayList<Integer>[] A;
    static boolean visit[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        A = new ArrayList[n+1];
        visit = new boolean[n+1];

        for(int i =1 ; i<n+1;i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<m;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }
        int cnt = 0;
        for(int i = 1; i<n+1; i++){
            if(!visit[i]){
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
    static void dfs(int v){
        if(visit[v]){
            return;
        }
        visit[v] = true;
        for(int i : A[v]){
            if (visit[i] == false){
                dfs(i);
            }
        }

    }
}
