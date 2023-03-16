package GraphTheory;

import java.util.*;
import java.io.*;

public class Problem24445 {
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	  static int cnt = 1;
	  static Queue<Integer> q = new LinkedList<>();
	  static int[] visited;
	  public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int R = Integer.parseInt(st.nextToken());

	    for (int i=0; i<M; i++){
	      st = new StringTokenizer(br.readLine(), " ");
	      int a = Integer.parseInt(st.nextToken());
	      int b = Integer.parseInt(st.nextToken());
	      if (map.get(a) == null) map.put(a, new ArrayList<Integer>());
	      if (map.get(b) == null) map.put(b, new ArrayList<Integer>());
	      map.get(a).add(b);
	      map.get(b).add(a);
	    }

	    for (ArrayList<Integer> list : map.values()){
	      Collections.sort(list, Collections.reverseOrder());
	    }

	    visited = new int[N+1];
	    q.add(R);
	    bfsFn(R);
	    StringBuilder sb = new StringBuilder();
	    for (int i=0; i<visited.length; i++){
	      if (i != 0)sb.append(visited[i]).append("\n");
	    }
	    System.out.print(sb);
	    
	    
	  }

	  static void bfsFn(int R){
	    q.add(R);
	    visited[R] = cnt;

	    while(!q.isEmpty()){
	      int cur = q.poll();
	    if (map.get(cur) != null){  
	      for (int i=0; i<map.get(cur).size(); i++){
	        int index = map.get(cur).get(i);
	        if (visited[index] == 0){
	          cnt++;
	          visited[index] = cnt;
	          q.add(index);
	        }
	      }
	    }
	    }

	    
	  }
}
