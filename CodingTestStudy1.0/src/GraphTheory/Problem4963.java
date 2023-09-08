package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem4963 {
	
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}, {-1,-1}, {-1,1}, {1,1}, {1,-1}};
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			str = new StringTokenizer(br.readLine(), " ");
			
			w = Integer.parseInt(str.nextToken());
			h = Integer.parseInt(str.nextToken());
			
			if (w == 0 && h == 0) {
				break;
			}
			
			map = new int[h][w];
			for (int i=0; i<h; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
				}
			}
			
			visited = new boolean[h][w];
			int cnt = 0;
			for (int i=0; i<h; i++) {
				for (int j=0; j<w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						cnt++;
						bfsFn(i,j);
					}
				}
			}
			sb.append(cnt).append("\n");
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
			
			for (int i=0; i<8; i++) {
				int nx = cx + dir[i][0];
				int ny = cy + dir[i][1];
				
				if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
					continue;
				}
				
				if (visited[nx][ny]) {
					continue;
				}
				
				if (map[nx][ny] == 0) {
					continue;
				}
				
				q.add(new int[] {nx,ny});
				visited[nx][ny] = true;
			}
		}
	}
}
