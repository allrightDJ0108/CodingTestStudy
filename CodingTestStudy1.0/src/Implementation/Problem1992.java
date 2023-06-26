package Implementation;

import java.io.*;

public class Problem1992 {
	static int N;
	static int[][] arr;
	static int[] dirX = { 0, 0, 1, 1 };
	static int[] dirY = { 0, 1, 0, 1 };
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String[] c = str.split("");
			for (int j = 0; j < c.length; j++) {
				arr[i][j] = Integer.parseInt(c[j]);
			}

		}

		for (int x = 0; x < N; x += 2) {
			for (int y = 0; y < N; y += 2) {
				sb.setLength(0);
				int temp = 0;
				for (int k = 0; k < 4; k++) {
					int a = x + dirX[k];
					int b = y + dirY[k];
					if (a < N && b < N && a >= 0 && b >= 0) {
						sb.append(arr[a][b]);
						temp += arr[a][b];
					}
				}

				System.out.println(temp);
				if (temp == 4) {
					sb2.append(1);
				} else if (temp == 0) {
					sb2.append(0);
				} else {
					sb2.append("(").append(sb).append(")");
				}
				System.out.println(sb2);
				System.out.println("=====");
			}
		}

	}

	static StringBuilder func() {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			if (arr[i][i] == 0) {
				cnt++;
			}
			sb.append(arr[i][i]);

		}
		if (cnt == 4) {
			sb.setLength(0);
			sb.append(0);
		}
		if (cnt == 0) {
			sb.setLength(0);
			sb.append(1);
		}

		return sb;
	}
}
