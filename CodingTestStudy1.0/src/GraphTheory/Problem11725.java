package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem11725 {
	
	static int N;
	static ArrayList<Integer>[] arr;
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N+1];
		for (int i=1; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		visited = new boolean[N+1];
		parent = new int[N+1];
		
		for (int i=0; i<N-1; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		
		bfsFn(1);
		
		for (int i=2; i<N+1; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfsFn(int x) {
		q.add(x);
		visited[x] = true;
		
		while(!q.isEmpty()) {
			int t = q.poll();
			
			for (int temp : arr[t]) {
				if (!visited[temp]) {
					parent[temp] = t;
					visited[temp] = true;
					q.add(temp);
				}
				
			}
		}
	}

}
