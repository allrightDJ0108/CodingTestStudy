package BinarySearch;

import java.io.*;
import java.util.*;

public class Problem10815 {

	static int N, M;
	static int[] arrN;
	static int[] arrM;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arrN = new int[N];
		str = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(str.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		arrM = new int[M];
		str = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			arrM[i] = Integer.parseInt(str.nextToken());
		}

		Arrays.sort(arrN);

		for (int i = 0; i < M; i++) {
			sb.append(func(arrM[i])).append(" ");
		}

		System.out.println(sb);
	}

	static int func(int x) {
		int result = 0;

		int start = 0;
		int end = N - 1;
		int mid = 0;

		while (start <= end) {

			mid = (start + end) / 2;

			if (arrN[mid] == x) {
				result = 1;
				break;
			}

			if (arrN[mid] > x) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return result;
	}
}
