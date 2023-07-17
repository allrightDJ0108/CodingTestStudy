package GraphTheory;

import java.io.*;

public class Problem16918 {
	
	static int R,C,N;
	static int[][] arr;
	static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		N = Integer.parseInt(input[2]);
		
		arr = new int[R][C];
		
		for (int i=0; i<R; i++) {
			input = br.readLine().split("");
			for (int j=0; j<C; j++) {
				//빈칸이면 0, 폭탄이 있으면 1
				if (input[j].equals(".")) {
					arr[i][j] = 0;
				} else if (input[j].equals("O")) {
					arr[i][j] = 1;
				}
			}
		}
		
		int ind = 1;
		while(ind++ <= N) {
			int tempT = ind % 2;
			
			for (int i=0; i<R; i++) {
				for (int j=0; j<C; j++) {
					if (tempT == 1) {
						if (arr[i][j] == 1) {
							arr[i][j] = 2;
						} else arr[i][j] = 1;
					} else if (tempT == 0) {
						if (arr[i][j] == 2) {
							bombFunc(i,j);
						}
					}
					
				}
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (arr[i][j] == 0) {
					sb.append(".");
				} else {
					sb.append("O");
				}
				
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void bombFunc(int x, int y) {
		arr[x][y] = 0;
		for (int i=0; i<4; i++) {
			int cx = x + dir[i][0];
			int cy = y + dir[i][1];
			if (cx >= 0 && cy >= 0 && cx < R && cy < C ) {
				if (arr[cx][cy] != 2) {
					arr[cx][cy] = 0;
				}
			}
		}
	}

}
