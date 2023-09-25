package Samsung;

import java.io.*;
import java.util.*;

public class Problem17143_re {
	
	static int r, c, m;
	static int[][] shark;
	static int[][] map;
	
	static int[][] dir = {{},{-1,0}, {1,0}, {0,1}, {0,-1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(str.nextToken());
		c = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		
		shark = new int[m+1][5];
		map = new int[r+1][c+1];
		
		for (int i=1; i<=m; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			shark[i][0] = Integer.parseInt(str.nextToken());
			shark[i][1] = Integer.parseInt(str.nextToken());
			shark[i][2] = Integer.parseInt(str.nextToken());
			shark[i][3] = Integer.parseInt(str.nextToken());
			shark[i][4] = Integer.parseInt(str.nextToken());
			int x = shark[i][0];
			int y = shark[i][1];
			map[x][y] = i;
		}
		
		int ind = 0;
		int score = 0;
		while (ind++ < c) {
			for (int i=1; i<= r; i++) {
				if (map[i][ind] != 0) {
					int num = map[i][ind];
					score += shark[num][4];
					map[i][ind] = 0;
					shark[num][0] = 0;
					shark[num][1] = 0;
					break;
				}
			}
			movingShark();
		}
		
		System.out.println(score);
	}
	
	static void movingShark() {
		int[][] tmap = new int[r+1][c+1];
		for (int i=1; i<=m; i++) {
			int cx = shark[i][0];
			int cy = shark[i][1];
			int size = shark[i][2];
			int d = shark[i][3];
			int nx = cx; 
			int ny = cy;
			if (cx == 0 && cy == 0) continue;
			for (int k=0; k<size; k++) {
				nx = nx + dir[d][0];
				ny = ny + dir[d][1];
				
				if (nx <= 0 || nx > r || ny <= 0 || ny > c) {
					if (d == 1) {
						d = 2;
					} else if (d == 2) {
						d = 1;
					} else if (d == 3) {
						d = 4;
					} else if (d == 4) {
						d = 3;
					}
					k = k-2;
				}
				
			}
			
			if (tmap[nx][ny] != 0) {
				int prev = tmap[nx][ny];
				if (shark[prev][4] < shark[i][4]) {
					tmap[nx][ny] = i; 
				}
			} else {
				tmap[nx][ny] = i;
			}
			
			if (size != 0) {
				shark[i][0] = nx;
				shark[i][1] = ny;
				shark[i][3] = d;
			}
			
		}
		
		map = tmap;
	}
	

}