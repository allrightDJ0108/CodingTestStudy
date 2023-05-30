package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem7576 {
	
	static int[][] box;
	static int M,N;
	static int[] dirX = {1,-1,0,0};
	static int[] dirY = {0,0,1,-1};
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N+1][M+1];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					q.add(new int[]{i,j});
				}
			}
		}
		System.out.println(tomatoFn());
	}
	
	static int tomatoFn() {
		while (!q.isEmpty()) {
			int t[] = q.poll();
			int x = t[0];
			int y = t[1];
			for (int i=0; i<4; i++) {
				int dx = x + dirX[i];
				int dy = y + dirY[i];
				if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
					if (box[dx][dy] == 0) {
						box[dx][dy] = box[x][y] + 1;
						q.add(new int[] {dx,dy});
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (box[i][j] == 0) {
					return -1;
				} else {
					if (max < box[i][j]) {
						max = box[i][j];
					}
				}
			}
		}
		
		return max - 1;
		
	}
}
