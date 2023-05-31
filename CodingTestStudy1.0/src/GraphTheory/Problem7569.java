package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem7569 {
	static int M, N, H;
	static int max = -999;
	static int[][][] box;
	static int[] dirZ = { 1, -1, 0, 0, 0, 0 };
	static int[] dirX = { 0, 0, 1, -1, 0, 0 };
	static int[] dirY = { 0, 0, 0, 0, 1, -1 };
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		box = new int[H + 1][N + 1][M + 1];

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					box[h][i][j] = Integer.parseInt(st.nextToken());
					if (box[h][i][j] == 1) {
						q.add(new int[] { h, i, j });
					}
				}
			}
		}
		System.out.println(bfsFn());

	}

	static int bfsFn() {
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int z = temp[0];
			int x = temp[1];
			int y = temp[2];

			for (int i = 0; i < 6; i++) {
				int dz = z + dirZ[i];
				int dx = x + dirX[i];
				int dy = y + dirY[i];

				if (dx >= 0 && dy >= 0 && dz >= 0 && dx < N && dy < M && dz < H) {
					if (box[dz][dx][dy] == 0) {
						box[dz][dx][dy] = box[z][x][y] + 1;
						q.add(new int[] { dz, dx, dy });
					}
				}
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box[i][j][k] == 0) {
						return -1;
					} else {
						if (max < box[i][j][k]) {
							max = box[i][j][k];
						}
					}
				}

			}
		}

		if (max == 1)
			return 0;

		return max - 1;
	}
}
