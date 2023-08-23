package DynamicProgramming;

import java.io.*;

public class Problem1699 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		int[] num = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			num[i] = i * i;
		}

		dp[1] = 1;
		if (N > 1) {
			dp[2] = 2;
		}
		if (N > 2) {
			dp[3] = 3;
		}
		for (int i = 4; i < N + 1; i++) {
			//1의 제곱수로만 표현할 수 있는 개수 최소화
			dp[i] = i;
			for (int j = 1; num[j] <= i; j++) {
				//N에 가장 가까운 제곱수를 뺀 dp값 - 1
				dp[i] = Math.min(dp[i - num[j]] + 1, dp[i]);
				// 처음 세웠던 점화식(오답)
				// dp[i] = Math.min(i / num[j] + i % num[j], dp[i]);
			}
		}

		System.out.println(dp[N]);
	}
}
