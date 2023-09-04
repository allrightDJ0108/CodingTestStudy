package Backtracking;

import java.io.*;
import java.util.*;

public class Problem14889 {

	static int N;
	static int[][] arr;
	static boolean[] visit;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		visit = new boolean[N + 1];

		for (int i = 1; i < N + 1; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		back(1, 0);
		System.out.println(result);
	}

	static void back(int idx, int depth) {
		if (depth == N / 2) {
			diff();
			return;
		}

		for (int i = idx; i < N+1; i++) {
			if (!visit[i]) {
				visit[i] = true;
				back(i + 1, depth + 1);
				visit[i] = false;
			}
		}
	}

	static void diff() {
		int tS = 0;
		int tL = 0;

		for (int i = 1; i < N; i++) {
			for (int j = i; j < N + 1; j++) {
				if (visit[i] == true && visit[j] == true) {
					tS += arr[i][j] + arr[j][i];

				} else if (visit[i] == false && visit[j] == false) {
					tL += arr[i][j] + arr[j][i];
				}
			}
		}

		int val = Math.abs(tS - tL);
		result = Math.min(val, result);
	}
}
