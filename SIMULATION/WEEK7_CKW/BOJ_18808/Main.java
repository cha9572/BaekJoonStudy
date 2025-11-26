package SIMULATION.WEEK7_CKW.BOJ_18808;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[] R, C;
    static int[][][] sticker;

    public static boolean check(int spin, int[][] note, int ystart, int xstart, int stiNum){
        if(spin==0) { // 0도
            for (int i = 0; i < R[stiNum]; i++) {
                for (int j = 0; j < C[stiNum]; j++) {
                    if (sticker[stiNum][i][j] == 1) {
                        if (note[ystart + i][xstart + j] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        else if(spin==1) { // 90도
            for(int i=0; i<C[stiNum]; i++) {
                for(int j=R[stiNum]-1; j>=0; j--) {
                    if(sticker[stiNum][j][i] == 1) {
                        if(note[ystart + j][xstart + i] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        else if(spin==2) { // 180도
            for(int i=R[stiNum]-1; i>=0; i--) {
                for(int j=0; j<C[stiNum]; j++) {
                    if(sticker[stiNum][i][j] == 1) {
                        if(note[ystart + i][xstart + j] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        else if(spin==3) { // 270도
            for(int i=0; i<C[stiNum]; i++) {
                for(int j=0; j<R[stiNum]; j++) {
                    if(sticker[stiNum][i][j] == 1) {
                        if(note[ystart + i][xstart + j] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void update(int spin, int[][] note, int ystart, int xstart, int stiNum){
        if(spin==0) {
            for(int i=0; i<R[stiNum]; i++){
                for(int j=0; j<C[stiNum]; j++){
                    note[ystart+i][xstart+j] = sticker[stiNum][i][j];
                }
            }
        }
        else if(spin==1) {
            for(int i=0; i<C[stiNum]; i++) {
                for(int j=R[stiNum]-1; j>=0; j--) {
                    note[ystart+i][xstart + j] = sticker[stiNum][i][j];
                }
            }
        }
        else if(spin==2) {
            for(int i=R[stiNum]-1; i>=0; i--) {
                for(int j=0; j<C[stiNum]; j++) {
                    note[ystart+i][xstart + j] = sticker[stiNum][i][j];
                }
            }
        }
        else if(spin==3) {
            for(int i=0; i<C[stiNum]; i++) {
                for(int j=0; j<R[stiNum]; j++) {
                    note[ystart+i][xstart + j] = sticker[stiNum][i][j];
                }
            }
        }

    }

    public static void search(int stiNum, int[][] note){

        if(stiNum==K){
            long count = Arrays.stream(note).flatMapToInt(Arrays::stream).filter(num -> num == 0).count();
            System.out.println(count);
            return;
        }

        for(int i=0; i<4; i++) { // 0도 90도 180도 270도
            if(i%2==0) { // 0도 180도
                for (int ystart = 0; ystart <= N - R[stiNum]; ystart++) {
                    for (int xstart = 0; xstart <= M - C[stiNum]; xstart++) {
                        if (check(i, note, ystart, xstart, stiNum)) {
                            update(i, note, ystart, xstart, stiNum);
                            search(stiNum + 1, note);
                        }
                        search(stiNum+1, note);
                    }
                }
            }
            else{ // 90도 270도
                for (int ystart = 0; ystart <= N - C[stiNum]; ystart++) {
                    for (int xstart = 0; xstart <= M - R[stiNum]; xstart++) {
                        if (check(i, note, ystart, xstart, stiNum)) {
                            update(i, note, ystart, xstart, stiNum);
                            search(stiNum + 1, note);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] note = new int[N][M];
        sticker = new int[4][10][10];
        R = new int[K]; C = new int[K];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());

            for(int j = 0; j<R[i]; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k<C[i]; k++){
                    sticker[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        search(0, note);


    }

}
