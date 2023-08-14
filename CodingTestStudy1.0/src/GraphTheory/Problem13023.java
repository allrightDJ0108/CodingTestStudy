package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem13023 {

	static int N, M;
	//static int[][] arr;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		//arr = new int[N][N];
		list = new ArrayList[N];
		visited = new boolean[N];
		
		for (int i=0; i<N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			list[x].add(y);
			list[y].add(x);
		}

		// dfs
		for (int i = 0; i < N; i++) {
			if (result == 0) {
				dfsFn(i, 1);
			}

		}

		System.out.println(result);
	}

	static void dfsFn(int x, int count) {
		
		//ABCDE가 친구이려면 깊이가 5여야 함
		if (count == 5) {
			result = 1;
			return;
		}

		visited[x] = true;
		for (int j : list[x]) {
			if (!visited[j]) {
				dfsFn(j, count+1);
			}
		}
		visited[x] = false;
	}
}
