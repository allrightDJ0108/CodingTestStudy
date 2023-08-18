package BinarySearch;

import java.io.*;
import java.util.*;

public class Problem1654 {
	
	static int K, N;
	static long[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		K = Integer.parseInt(str.nextToken());
		N = Integer.parseInt(str.nextToken());
		arr = new long[K];
		
		long max = 0;
		for (int i=0; i<K; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		long start = 1;
		long end = max;
		long result = 0;
		
		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			
			for (int i=0; i<K; i++) {
				sum += arr[i] / mid;
			}
			
			
			if (sum >= N) {
				start = mid + 1;
				result = Math.max(result, mid);
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(result);
	}
}
