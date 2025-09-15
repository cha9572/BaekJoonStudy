package STACK.WEEK3_CKW.BOJ_3015;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        long cnt=0;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<N; i++) {
            while(!stack.isEmpty() && stack.peek()[0] < num[i]) {
                cnt+=stack.pop()[1];
            }

            if(stack.isEmpty()){
                stack.push(new int[] {num[i], 1});
            }
            else{
                if(stack.peek()[0]>num[i]){
                    stack.push(new int[] {num[i], 1});
                    cnt++;
                }
                else{
                    cnt+=stack.peek()[1]++;
                    if(stack.size()>1)
                        cnt++;
                }
            }
        }
        bw.write(cnt+"\n");
        bw.flush();


        //눈물의 3시간동안 연구한 시간초과 걸리는 쓰레기 코드
        /*Stack<Integer> stack = new Stack<>();
        long cnt=0;
        int same=0;

        for(int i=0; i<N; i++) {
            //System.out.println();
            if(stack.isEmpty()) {
                stack.push(num[i]);
            }
            else if(stack.peek() == num[i]){
                if(same==0) {
                    while (stack.peek() == num[i]) {
                        //System.out.print("{"+stack.peek()+", " + num[i]+"}, ");
                        same++;
                        stack.pop();
                        cnt++;
                        if (stack.isEmpty())
                            break;
                    }
                    if (!stack.isEmpty()) {
                        //System.out.print("{"+stack.peek()+", " + num[i]+"}, ");
                        cnt++;
                    }
                    for (int j = 0; j < same; j++)
                        stack.push(num[i]);
                }
                else {
                    if(stack.size() > same)
                        cnt++;
                    cnt+=++same;
                    for(int j=0; j<same; j++){
                        //System.out.print("{"+stack.peek()+", " + num[i]+"}, ");
                    }

                }
                stack.push(num[i]);
            }
            else if(stack.peek() < num[i]){
                same=0;
                while(stack.peek() <= num[i]){
                    if(stack.peek() < num[i]){
                        //System.out.print("{"+stack.peek()+", " + num[i]+"}, ");
                        stack.pop();
                        cnt++;
                    }
                    else {
                        //System.out.print("{"+stack.peek()+", " + num[i]+"}, ");
                        same++;
                        stack.pop();
                        cnt++;
                    }
                    if(stack.isEmpty())
                        break;
                }
                if(!stack.isEmpty()){
                    //System.out.print("{"+stack.peek()+", " + num[i]+"}, ");
                    cnt++;
                }
                for(int j=0; j<same; j++){
                    stack.push(num[i]);
                }
                stack.push(num[i]);
            }
            else if(stack.peek() > num[i]){
                same=0;
                //System.out.print("{"+stack.peek()+", " + num[i]+"}, ");
                cnt++;
                stack.push(num[i]);
            }
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(cnt+"\n");
        bw.flush();


         */
    }

}
