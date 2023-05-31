package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem16928 {
	static int N, M;
	static int[] move = new int[100 + 1];
	// static int[][] map = new int[100+1][100+1];
	static Queue<Integer> q = new LinkedList<>();
	static int[] visited = new int[100 + 1];
	static int[] count = new int[100 + 1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			move[x] = y;

		}
		bfsFn();
	}

	static void bfsFn() {
		q.add(1);
		visited[1] = 1;
		count[1] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == 100) {
				System.out.println(count[cur]);
				return;
			}

			for (int i = 1; i <= 6; i++) {
				int temp = cur + i;
				if (temp > 100)
					continue;
				if (visited[temp] == 1)
					continue;
				visited[temp] = 1;

				if (move[temp] != 0) {
					if (visited[move[temp]] != 1) {
						q.add(move[temp]);
						visited[move[temp]] = 1;
						count[move[temp]] = count[cur] + 1;
					}
				} else {
					q.add(temp);
					count[temp] = count[cur] + 1;
				}
			}
		}
	}
}
