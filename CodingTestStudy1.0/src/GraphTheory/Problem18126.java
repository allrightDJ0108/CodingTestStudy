package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem18126 {
	
	static long[][] arr;
	static Queue<Integer> q = new LinkedList<>();
	static long[] visited;
	static long result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		
		int N = Integer.parseInt(br.readLine());
		arr = new long[N+1][N+1];
		visited = new long[N+1];
		
		for (int i=0; i<N-1; i++) {
			str = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			long d = Long.parseLong(str.nextToken());
			arr[x][y] = d;
			arr[y][x] = d;
		}
		
		findDistance(1);
		
		for (int i=0; i<visited.length; i++) {
			if (result < visited[i]) result = visited[i];
		}
		System.out.println(result);
	}
	
	static void findDistance(int n) {
		q.add(n);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i=0; i<arr.length; i++) {
				if (arr[cur][i] != 0 ) {
					if(visited[i] == 0 || visited[cur]+arr[cur][i] > visited[i]) {
						visited[i] = visited[cur] + arr[cur][i];
						q.add(i);
						arr[cur][i] = 0;
						arr[i][cur] = 0;
					}
					
				}
			}
			
			
		}
	}
	
	//처음 시도한 풀이
	/*
	static void findDistance() {
		visited[1] = 1;
		q.add(1);
		long temp = 0;
		
		while(!q.isEmpty()) {
			result += temp;
			temp = 0;
			int cur = q.poll();
			int next = 0;
			
			for (int i=0; i<arr.length; i++) {
				if (arr[cur][i] != 0 && visited[i] != 1) {
					if (temp < arr[cur][i]) {
						temp = arr[cur][i];
						next = i;
					}
				}
			}
			
			if (next != 0) {
				q.add(next);
				visited[cur] = 1;
			}
			
		}
	}
	*/
}
