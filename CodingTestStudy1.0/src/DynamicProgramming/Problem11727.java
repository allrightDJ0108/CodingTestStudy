package DynamicProgramming;

import java.io.*;

public class Problem11727 {
	static int[] d = new int[1000 + 1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		d[1] = 1;
		d[2] = 3;
		for (int i = 3; i < N + 1; i++) {
			d[i] = (d[i - 1] + d[i - 2] * 2) % 10007;
		}

		System.out.println(d[N]);
	}
}
