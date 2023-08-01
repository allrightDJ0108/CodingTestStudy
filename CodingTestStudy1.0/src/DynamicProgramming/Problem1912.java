package DynamicProgramming;

import java.io.*;
import java.util.*;

public class Problem1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		str = new StringTokenizer(br.readLine());
		
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		dp[0] = arr[0];
		int result = dp[0];
		
		for (int i=1; i<N; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			if (result < dp[i]) result = dp[i];
		}
		
		System.out.println(result);
	}
}
