package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem2667 {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	static int cnt = 0;
	static int temp = 0;
	static int N;
	static ArrayList<Integer> resArr = new ArrayList<Integer>();

	static int[] dirX = { 1, -1, 0, 0 };
	static int[] dirY = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];
		visited = new int[N + 1][N + 1];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		for (int x = 0; x < N + 1; x++) {
			for (int y = 0; y < N + 1; y++) {
				temp = 0;
				if (arr[x][y] == 1 && visited[x][y] == 0) {
					dfsFn(x, y);
					resArr.add(temp);
					cnt++;
				}
			}
		}

		Collections.sort(resArr);

		System.out.println(resArr.size());
		for (int i = 0; i < resArr.size(); i++) {
			System.out.println(resArr.get(i));
		}
	}

	static void dfsFn(int x, int y) {
		visited[x][y] = 1;
		temp++;
		for (int i = 0; i < 4; i++) {
			int newX = x + dirX[i];
			int newY = y + dirY[i];

			if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
				if (arr[newX][newY] == 1 && visited[newX][newY] == 0) {
					dfsFn(newX, newY);
				}
			}
		}
	}
}
