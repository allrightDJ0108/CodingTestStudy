package Samsung;

import java.io.*;
import java.util.*;

public class Problem14503 {

	static int N, M, r, c, d;
	static int[][] map;
	// 북(서) 동(북) 남(동) 서(남)
	static int[] dirX = { -1, 0, 1, 0 };
	static int[] dirY = { 0, 1, 0, -1 };
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;

		str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		map = new int[N][M];

		str = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(str.nextToken());
		c = Integer.parseInt(str.nextToken());
		d = Integer.parseInt(str.nextToken());

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		System.out.println(func());
	}

	static int func() {
		int result = 0;

		q.add(new int[] { r, c, d });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX, curY = 0;
			if (map[cur[0]][cur[1]] == 0) {
				map[cur[0]][cur[1]] = 99;
				result++;
			}
			boolean flag = false;
			for (int i = 0; i < 4; i++) {
				int dir = (cur[2] + 3) % 4;
				curX = cur[0] + dirX[dir];
				curY = cur[1] + dirY[dir];

				if (curX >= 0 && curX < N && curY >= 0 && curY < M) {
					if (map[curX][curY] == 0) {
						q.add(new int[] { curX, curY, dir });
						flag = true;
						break;
					}
				}
				cur[2] = (cur[2] + 3) % 4;
			}
			if (!flag) {
				int dir = (cur[2] + 2) % 4; // 뒤로 이동
				curX = cur[0] + dirX[dir];
				curY = cur[1] + dirY[dir];
				if (curX >= 0 && curX < N && curY >= 0 && curY < M) {
					if (map[curX][curY] != 1) {
						q.add(new int[] { curX, curY, cur[2] });
					}
				}
			}

		}

		return result;
	}

}
