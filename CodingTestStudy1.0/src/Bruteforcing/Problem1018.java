package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1018 {
	
	static String[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		arr = new String[N][M];
		
		for (int i=0; i<N; i++) {
			arr[i] = br.readLine().split("");
		}
		
		int NRow = N - 7;
		int MRow = M - 7;
		
		int ans = 100000;
		for (int i=0; i<NRow; i++) {
			for (int j=0; j<MRow; j++) {
				ans = Math.min(ans, func(i,j));
			}
		}
		
		System.out.println(ans);

	}
	
	static int func(int i, int j) {
		int B = 0;
		int W = 0;
		
		for (int n=i; n<i+8; n++) {
			for (int m=j; m<j+8; m++) {
				if (( n + m ) % 2 == 0 ) {		//짝수칸
					if (arr[n][m].equals("W")) W++;
					else B++;
				} else {						//홀수칸
					if (arr[n][m].equals("B")) W++;
					else B++;
				}
				
			}
		}
		
		return Math.min(B, W);
	}
}

