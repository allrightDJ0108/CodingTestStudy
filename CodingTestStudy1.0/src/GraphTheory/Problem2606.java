package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem2606 {
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	static int[] visited;
	static int R = 1;
	//static Queue<Integer> q = new LinkedList<Queue>(;)
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (map.get(a) == null) map.put(a, new ArrayList<Integer>());
			if (map.get(b) == null) map.put(b, new ArrayList<Integer>());
			map.get(a).add(b);
			map.get(b).add(a);
		}
		
		for (ArrayList<Integer> val : map.values()){
			Collections.sort(val);
		}
		
		visited = new int[N+1];
		//dfsFn(R);

		int cnt = 0;
		for (int i=0; i<visited.length; i++) {
			if (visited[i] == 1) cnt++;
		}
		System.out.println(cnt);
	}
	
	static void dfsFn(int R) {
		visited[R] = 1;
		
		if (map.get(R) != null) {
			for (int i=0; i<map.get(R).size(); i++) {
				int temp = map.get(R).get(i);
				if (visited[temp] == 0) {
					dfsFn(temp);
				}
			}
		}
	}
	
	static void bfsFn(int R) {
		
	}
}
