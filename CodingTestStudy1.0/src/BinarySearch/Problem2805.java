package BinarySearch;

import java.io.*;
import java.util.*;

public class Problem2805 {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		arr = new int[N];

		long max = 0;
		str = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
			max = Math.max(max, arr[i]);
		}

		long start = 0;
		long end = max;

		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;

			for (int i = 0; i < N; i++) {
				if (arr[i] > mid) {
					sum += arr[i] - mid;
				}
			}

			if (sum >= M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		System.out.println(end);
	}

}