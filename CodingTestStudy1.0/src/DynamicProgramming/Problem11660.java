package DynamicProgramming;

import java.io.*;
import java.util.*;

public class Problem11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		int[][] add = new int [N+1][N+1];
		
		for (int i=1; i<N+1; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int j=1; j<N+1; j++) {
				add[i][j] = Integer.parseInt(str.nextToken()) + add[i][j-1];
			}
		}
		
		for (int i=0; i<M; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int px = Integer.parseInt(str.nextToken());
			int py = Integer.parseInt(str.nextToken());
			int nx = Integer.parseInt(str.nextToken());
			int ny = Integer.parseInt(str.nextToken());
			
			int sum = 0;
			for (int a = px; a <= nx; a++ ) {
				sum += add[a][ny] - add[a][py-1];
			}
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
