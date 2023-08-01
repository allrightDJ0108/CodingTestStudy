package DynamicProgramming;

import java.io.*;
import java.util.*;

public class Problem11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		str = new StringTokenizer(br.readLine());
		for (int i=0 ;i<N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		int[] dp = new int[N];
		
		for (int i=0; i<N; i++) {
			dp[i] = 1;
			
			for (int j=0; j <= i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			max = dp[i] > max ? dp[i] : max;	//순열의 가장 마지막 순서를 탐색
		}
		System.out.println(max);	//dp[N-1]의 값으로 출력하면 오답 - 가장 마지막이 순열의 구성으로 결정되지 않을 수도 있기 때문
	}
}
