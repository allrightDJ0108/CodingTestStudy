package ThisIsCT;

import java.io.*;
import java.util.*;

public class ch04_01 {
	// Ch.04 구현
	// 예제 4-1. 상하좌우

	static int N;
	static String[] plan;
	static int[][] map;
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		plan = br.readLine().split(" ");

		bfsFn();
		
		int result[] = q.poll();
		int resX = result[0] + 1;
		int resY = result[1] + 1;
		System.out.println(resX + " "+ resY);

	}

	static void bfsFn() {
		q.add(new int[] { 0, 0 });

		int planIdx = 0;

		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			int nextX = 0, nextY = 0;

			if (plan[planIdx].equals("L")) {
				nextX = curX + 0;
				nextY = curY - 1;

			} else if (plan[planIdx].equals("R")) {
				nextX = curX + 0;
				nextY = curY + 1;
				
			} else if (plan[planIdx].equals("U")) {
				nextX = curX - 1;
				nextY = curY + 0;

			} else if (plan[planIdx].equals("D")) {
				nextX = curX + 1;
				nextY = curY + 0;
			}

			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
				q.add(new int[] { nextX, nextY });
			} else {
				q.add(new int[] { curX, curY });
			}

			planIdx++;
			if (planIdx == plan.length) return;
		}

	}
}
