package GraphTheory;

import java.util.*;
import java.io.*;

public class Problem24444 {
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	  static int[] visited;
	  static Queue<Integer> q = new LinkedList<>();
	  static int cnt = 0;
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
	      map.get(a).add(b);
	      if (map.get(b) == null) map.put(b, new ArrayList<Integer>());
	      map.get(b).add(a);
	    }
	    //map 정렬(오름차순)
	    for (ArrayList<Integer> list : map.values()){
	      Collections.sort(list);
	    }
	    visited = new int[N+1];
	    cnt = 1;
	  //  q.add(R);
	    bfsFn(R);
	    
	    StringBuilder sb = new StringBuilder();
	    for (int i=0; i<visited.length; i++){
	      if (i != 0) sb.append(visited[i]).append("\n");
	    }
	    System.out.print(sb);
	    
	  }
	  
	  public static void bfsFn(int R){
	    visited[R] = cnt;
	    q.add(R);
	    while (!q.isEmpty()){
	      int cur = q.poll();
	      
	      for (int i=0; i<map.get(cur).size(); i++){
	        if (visited[map.get(cur).get(i)] == 0){
	          cnt++;
	          visited[map.get(cur).get(i)] = cnt;
	          q.add(map.get(cur).get(i));
	        }
	      }
	    }
	    
	    
	  }
}
