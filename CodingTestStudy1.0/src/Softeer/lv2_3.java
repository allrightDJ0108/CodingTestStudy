package Softeer;

import java.util.*;
import java.io.*;

public class lv2_3 {
	// 장애물 인식 프로그램
	static int N;
	static int[][] map;
	static boolean[][] visited;

	static LinkedList<Integer> list = new LinkedList<>();
	static int cnt = 0;

	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] inp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inp[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					// 장애물이 있고 방문하지 않은 경우
					cnt++;
					bfsFn(i, j);
				}

			}

		}

		sb.append(cnt).append("\n");
		Collections.sort(list);
		for (int size : list)
			sb.append(size).append("\n");
		System.out.println(sb);

	}

	static void bfsFn(int x, int y) {
		q.add(new int[] { x, y });
		visited[x][y] = true;

		int tempCnt = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dir[i][0];
				int nextY = curY + dir[i][1];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || map[nextX][nextY] == 0 || visited[nextX][nextY]) {
					continue;
				} else {
					q.add(new int[] { nextX, nextY });
					visited[nextX][nextY] = true;
					tempCnt++;
				}

			}
		}

		list.add(tempCnt);

	}
}
