package DynamicProgramming;

import java.io.*;

public class Problem11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] in = br.readLine().split(" ");
		int[] P = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			P[i] = Integer.parseInt(in[i - 1]);
		}

		int[] dp = new int[N + 1];

		for (int x = 1; x < N + 1; x++) {
			dp[x] = P[x];
			for (int y = 1; y < x; y++) {
				dp[x] = Math.max(dp[x], P[y] + dp[x - y]);
			}
		}

		System.out.println(dp[N]);
	}
}
