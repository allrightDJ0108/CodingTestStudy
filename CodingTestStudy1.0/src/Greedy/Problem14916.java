package Greedy;

import java.io.*;

public class Problem14916 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        
        while (N > 0){
            //System.out.println(N);
            if (N % 5 == 0){
                cnt += N / 5;
                N = N % 5;
            } else {
                N = N - 2;
                cnt++;
            }
            
        }

        if (N < 0) {
			System.out.println(-1);
		} else {
			System.out.println(cnt);
		}
        
    }
}
