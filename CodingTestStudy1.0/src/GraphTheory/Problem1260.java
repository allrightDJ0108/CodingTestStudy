package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem1260 {
	
	static int N = 0;
	static int M = 0;
	static int V = 0;
	static int[] visited;
	static int[][] graph;
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		visited = new int[N+1];
		graph = new int[N+1][N+1];
		
		
		int i = 0;
		while (i++ < M) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		//DFS
		System.out.println(dfsFn(V));
		
		//visited 배열 초기화
		for (int k=0; k<visited.length; k++) {
			visited[k] = 0;
		}
		
		//sb 초기화
		sb.setLength(0);
		
		//BFS
		System.out.println(bfsFn(V));
		
	}
	
	static StringBuilder dfsFn(int V) {
		visited[V] = 1;
		sb.append(V).append(" ");
		for (int i=0; i<visited.length; i++) {
			if ((visited[i] == 0) && (graph[V][i] != 0)) {
				//방문된 적은 없지만 방문이 가능한 경우
				dfsFn(i);
			}
		}
		return sb;
	}
	
	//BFS의 대표적 형태라고 생각하고 외우기
	static StringBuilder bfsFn(int V) {
		q.add(V);
		visited[V] = 1;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for (int i=0; i<visited.length; i++) {
				if ((visited[i] == 0) && (graph[cur][i] != 0)) {
					//방문된 적은 없지만 방문이 가능한 경우
					visited[i] = 1;
					q.add(i);
				} 
			}
		}
		return sb;
	}

}
