package BFS;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2667 {
    static int N;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];

        for (int i = 0; i<N; i++){
            String[] arr = br.readLine().split("");
            for (int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                if(map[i][j] == 1 && !check[i][j]){
                    int data = bfs(i,j);
                    list.add(data);
                    cnt++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(cnt);
        for (int i = 0; i< list.size(); i++) {
            System.out.println(list.get(i));
        }
        br.close();
    }
    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        check[x][y] = true;
        int n = 1;
        while (!q.isEmpty()){
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];

            for (int i = 0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (!check[nx][ny] && map[nx][ny] == 1){
                    q.add(new int[] {nx,ny});
                    check[nx][ny] = true;
                    n++;
                }
            }
        }
        return n;
    }
}
