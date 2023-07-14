package ThisIsCT;

import java.io.*;
import java.util.*;

public class ch05_02 {
	//ch.05 DFS/BFS
	//미로 탈출
	
	static int N,M;
	static int[][] arr;
	static Queue<int[]> q = new LinkedList<>();
	static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		arr = new int[N][M];
		
		for (int i=0; i<N; i++) {
			input = br.readLine().split("");
			for (int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		bfsFn();
		
		System.out.println(arr[N-1][M-1]);
	}
	
	static void bfsFn() {
		q.add(new int[] {0,0});
		
		while (!q.isEmpty()) {
			int curQ[] = q.poll();
			int curX = curQ[0];
			int curY = curQ[1];
			
			int nextX = 0, nextY = 0;
			for (int i=0; i<4; i++) {
				nextX = curX + dir[i][0];
				nextY = curY + dir[i][1];
				
				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if (arr[nextX][nextY] == 1) {
						arr[nextX][nextY] = arr[curX][curY] + 1;
						q.add(new int[] {nextX, nextY});
					}
				}
			}
			
		}
	}
}
