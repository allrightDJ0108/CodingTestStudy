package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem1325 {

	static int N, M;
	static int[] visited;
	static int[] result;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		result = new int[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			list[x].add(y);
		}

		// DFS
		for (int i = 1; i < N + 1; i++) {
			visited = new int[N + 1];
			visited[i] = 1;
			dfsFn(i);
		}

		// 해킹 가능 최대개수
		int max = Integer.MIN_VALUE;
		for (int t : result) {
			max = Math.max(max, t);
		}

		// 출력
		for (int i = 1; i < N + 1; i++) {
			if (max == result[i]) {
				sb.append(i + " ");
			}
		}

		System.out.println(sb.toString().trim());
	}

	static void dfsFn(int t) {
		for (int temp : list[t]) {
			if (visited[temp] == 0) {
				result[temp] += 1;
				visited[temp] = 1;
				dfsFn(temp);
			}
		}
	}
}
