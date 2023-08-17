package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14501 {
	// 230817 풀이완료
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer str;
		int[] t = new int[N];
		int[] p = new int[N];
		
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			t[i] = Integer.parseInt(str.nextToken());
			p[i] = Integer.parseInt(str.nextToken());
		}
		
		int[] dp = new int[N+1];
		
		for (int i=0; i<N; i++) {
			int tt = t[i];
			int tp = p[i];
			
			if (i + tt <= N) {
				dp[i + tt] = Math.max(dp[i+tt], tp + dp[i] );
			}
			
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}

		System.out.println(dp[N]);

	}
}
