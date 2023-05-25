package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem1260_230525 {
	
	static int[][] graph;
	static int[] visited;
	static Queue<Integer> q = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		visited = new int[N+1];
		
		int i=0;
		while (i++ < M) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		//DFS
		System.out.println(dfsFn(V));
		
		sb.setLength(0);
		//visited 배열 초기화
		for (int k=0; k<visited.length; k++) {
			visited[k] = 0;
		}
		
		System.out.println(bfsFn(V));
	}
	
	static StringBuilder dfsFn(int V) {
		visited[V] = 1;
		sb.append(V).append(" ");
		for (int i=0; i < visited.length; i++) {
			if ((visited[i] == 0) && (graph[V][i] != 0)) {
				dfsFn(i);
			}
		}
		return sb;
	}
	
	static StringBuilder bfsFn(int V) {
		q.add(V);
		visited[V] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for (int i=0; i<visited.length; i++) {
				if ((visited[i] == 0) && (graph[cur][i] != 0)){
					visited[i] = 1;
					q.add(i);
				}
			}
		}
		
		return sb;
	}

}
