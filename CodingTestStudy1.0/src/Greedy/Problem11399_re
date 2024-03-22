package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11399_re {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());

		int[] list = new int[N];

		for (int i=0; i<N; i++) {
			list[i] = Integer.parseInt(str.nextToken());
		}

		Arrays.sort(list);

		int[] sum = new int[N];
		sum[0] = list[0];

		int result = sum[0];
		for (int i=1; i<N; i++) {
			sum[i] = sum[i-1] + list[i];
			result += sum[i];
			//System.out.println(sum[i]+" "+result);
		}

		System.out.println(result);
	}
}
