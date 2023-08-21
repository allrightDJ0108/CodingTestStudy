package DynamicProgramming;

import java.io.*;
import java.util.*;

public class Problem2225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());

		int[][] dp = new int[K][N + 1];
		// K는 개수
		// N은 만들고자 하는 수

		for (int i = 0; i < N + 1; i++) {
			dp[0][i] = 1;
		}

		for (int i = 0; i < K; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < K; i++) {
			for (int j = 1; j < N + 1; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				dp[i][j] = dp[i][j] % 1000000000;
			}
		}

		System.out.println(dp[K-1][N]);
	}
}
