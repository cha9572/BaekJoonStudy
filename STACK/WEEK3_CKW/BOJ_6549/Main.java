// 아직 못풀은 문제임 히스토그램에서 가장 큰 직사각형
package STACK.WEEK3_CKW.BOJ_6549;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n==0) break;

            int[] height = new int[n];

            for(int i = 0; i < n; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }
            long max = 0;
            Stack<int[]> stack = new Stack<>();

            for(int i = 0; i < n; i++) {
                if(stack.isEmpty()){
                    stack.push(new int[]{height[i], i});
                }
                else{
                    if(height[i]<stack.peek()[0]){
                        int ssize = stack.size();
                        int last = stack.peek()[1];
                        for(int j=0; j<ssize; j++){
                            if(stack.peek()[0] > height[i]){
                                int tmp = stack.peek()[0]*(last-stack.pop()[1]+1);
                                if(tmp>max)
                                    max = tmp;
                            }
                            else{
                                break;
                            }
                        }
                        stack.push(new int[]{height[i], i});
                    }
                    else{
                        stack.push(new int[]{height[i], i});
                    }
                }
            }

            if(!stack.isEmpty()){
                int last = stack.peek()[1];
                int ssize = stack.size();
                for(int j=0; j<ssize; j++){
                    int tmp = stack.peek()[0]*(last-stack.pop()[1]+1);
                    if(max<tmp)
                        max = tmp;
                }
            }

            System.out.println(max);
        }
    }
}
