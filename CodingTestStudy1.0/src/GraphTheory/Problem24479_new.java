package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem24479_new {
	//이차원 배열 이용 : 메모리 초과
	static int[][] arr;
	static int[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		visited = new int[N+1];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		System.out.println(dfsFn(R));
		for (int i=0; i<visited.length; i++) {
			if (i>0 && visited[i] == 0) {
				System.out.print(0);
			}
		}
	}
	
	public static StringBuilder dfsFn(int R) {
		
		visited[R] = 1;
		sb.append(R).append("\n");
		for (int i=0; i<visited.length; i++) {
			if (visited[i] == 0 && arr[R][i] != 0) {
				//방문한 적이 없으나 경로가 있는 경우
				dfsFn(i);
			} 
		}
		return sb;
	}
}
