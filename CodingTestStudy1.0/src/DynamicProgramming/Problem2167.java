package DynamicProgramming;

import java.io.*;
import java.util.*;

public class Problem2167 {
	//DP 다이나믹프로그래밍 활용해서 풀이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		int[][] arr = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		
		for (int i=1; i < N+1; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			
			for (int j=1; j < M+1; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
				dp[i][j] = arr[i][j] + dp[i][j-1];
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for (int k=0; k<K; k++) {
			str = new StringTokenizer(br.readLine(), " ");

			int i = Integer.parseInt(str.nextToken());
			int j = Integer.parseInt(str.nextToken());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			
			int sum = 0;
			for (int a = i; a < x + 1; a++) {
				sum += dp[a][y] - dp[a][j-1];
			}
			
			System.out.println(sum);
		}
	}
}
