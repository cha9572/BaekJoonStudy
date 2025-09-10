import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] building = new int[N];

        for(int i=0; i<N; i++) {
            building[i] = Integer.parseInt(br.readLine());
        }

        long cnt = 0;

        for(int i=0; i<N; i++) {
            int tmp = building[i];
            for(int j=i+1; j<N; j++) {
                if(tmp <= building[j]) {
                    break;
                }
                cnt++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(cnt + "\n");
        bw.flush();



    }



}
