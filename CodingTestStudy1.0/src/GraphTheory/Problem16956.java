package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem16956 {
	
	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
	static Queue<int[]> q = new LinkedList<>();
	static int result = 1;
	
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for (int i=0; i<R; i++) {
			String[] inp = br.readLine().split("");
			for (int j=0; j<C; j++) {
				int in = 0;
				if (inp[j].equals("S")) {
					in = 1;
				} else if (inp[j].equals("W")) {
					in = 2;
				}
				map[i][j] = in;
			}
		}
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j] == 2) {
					bfsFn(i,j);
					if (result == 0) {
						break;
					}
				}
			}
		}
		
		System.out.println(result);
		StringBuilder sb = new StringBuilder();
		if (result == 1) {
			for (int i=0; i<R; i++) {
				for (int j=0; j<C; j++) {
					if (map[i][j] == 0) {
						sb.append(".");
					}
					if (map[i][j] == 1) {
						sb.append("S");
					}
					if (map[i][j] == 2) {
						sb.append("W");
					}
					if (map[i][j] == 3) {
						sb.append("D");
					}
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
		
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
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
					continue;
				}
				
				if (visited[nx][ny]) {
					continue;
				}
				
				if (map[nx][ny] == 2) {
					continue;
				}
				
				if (map[nx][ny] == 3) {
					continue;
				}
				
				//1칸 내에 양이 있는 경우 바로 종료
				if (map[nx][ny] == 1) {
					result = 0;
					return;
				}
				
				if (map[nx][ny] == 0) {
					map[nx][ny] = 3;
					visited[nx][ny] = true;
				}
			}
		}
	}
}
