package DynamicProgramming;

import java.io.*;

public class Problem17626 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];

		arr[1] = 1;
		for (int i = 1; i < N + 1; i++) {
			int min = Integer.MAX_VALUE;

			for (int j = 1; j * j <= i; j++) {
				int temp = i - (j * j);
				min = Math.min(min, arr[temp]);
			}

			arr[i] = min + 1;
		}

		System.out.println(arr[N]);
	}
}
