package DynamicProgramming;

import java.io.*;

public class Problem2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");

		int n = Integer.parseInt(in[0]); // 동전의 개수
		int k = Integer.parseInt(in[1]); // 합

		int[] num = new int[n];
		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			int coin = num[i];
			for (int j = coin; j < k + 1; j++) {
				dp[j] = dp[j - coin] + dp[j];
			}
		}

		System.out.println(dp[k]);
	}

}
