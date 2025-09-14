package BFS.WEEK3.BOJ_1926;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] paper;
    static int size;

    public static void bps(int i, int j){
        int[] y = {1, 0, -1, 0};
        int[] x = {0, -1, 0, 1};
        size++;
        for(int k = 0; k < 4; k++){
            if(paper[i+x[k]][j+y[k]] == 1){
                paper[i+x[k]][j+y[k]] = 2;
                bps(i+x[k], j+y[k]);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        paper = new int[n+2][m+2];
        int cnt = 0;

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max=0;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(paper[i][j]==1) {
                    size=0;
                    paper[i][j]=2;
                    bps(i,j);
                    cnt++;
                    if(size>max){
                        max=size;
                    }
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(cnt + "\n");
        bw.write(max + "\n");
        bw.flush();


    }

}
