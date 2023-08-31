package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem14940 {
	
	static int N, M;
	static int[][] map;
	static int[][] res;
	static boolean[][] visited;
	static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
	static int gx, gy;
	static Queue<int[]> q = new LinkedList<>(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		map = new int[N][M];
		res = new int[N][M];
		visited = new boolean[N][M];
		
		boolean isChecked = false;
		
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if (map[i][j] == 2) {
					isChecked = true;
					gx = i;
					gy = j;
					break;
				}
			}
		}
		
		bfsFn(gx,gy);
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (!visited[i][j] && map[i][j] == -1) {
					sb.append(-1).append(" ");
				}
				sb.append(res[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfsFn(int x, int y) {
		q.add(new int[] {x,y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i=0; i<4; i++) {
				int nx = cx + dir[i][0];
				int ny = cy + dir[i][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				if (visited[nx][ny]) {
					continue;
				}
				
				if (map[nx][ny] == 0) {
					continue;
				}
				
				q.add(new int[] {nx,ny});
				res[nx][ny] = res[cx][cy] + 1;
				visited[nx][ny] = true;
				
			}
		}
		
	}
}
