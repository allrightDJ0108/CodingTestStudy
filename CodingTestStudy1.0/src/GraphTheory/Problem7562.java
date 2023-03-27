package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem7562 {

	static int[][] arr = new int[300][300];
	static StringTokenizer st;
	static Queue<int[]> q = new LinkedList<>();
	//이 부분 그림처럼 수정하면 될 것 같은데...!
	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	static int x, y, rx, ry;
	static int result = 0;

	//230327 푸는중
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int I = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			rx = Integer.parseInt(st.nextToken());
			ry = Integer.parseInt(st.nextToken());

			if (x != rx && y != ry) {
				bfsFn();
			}
			System.out.println(result);
		}
	}

	static void bfsFn() {
		q.add(new int[] { x, y });
		arr[x][y] = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int curX = cur[0] + dirX[i];
				int curY = cur[1] + dirY[i];
			}
		}
	}

}