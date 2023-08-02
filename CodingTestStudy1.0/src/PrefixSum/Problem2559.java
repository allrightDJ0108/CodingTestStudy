package PrefixSum;

import java.io.*;
import java.util.*;

public class Problem2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		int[] arr = new int[N + 1];
		
		str = new StringTokenizer(br.readLine());
		for (int i=1; i<N+1; i++) {
			//누적합 더하기
			arr[i] = Integer.parseInt(str.nextToken()) + arr[i-1];
		}
		
		int max = Integer.MIN_VALUE;
		int temp = 0;
		for (int i=K; i<=N; i++) {
			temp = arr[i] - arr[i-K];
			if (temp > max) max = temp;
		}
		
		System.out.println(max);
	}
}
