package GraphTheory;

import java.util.*;
import java.io.*;

public class Problem24480 {
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	  static int[] visited;
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
	    //map 정렬(내림차순)
	    for (ArrayList<Integer> list : map.values()){
	      Collections.sort(list, Collections.reverseOrder());
	    }
	    visited = new int[N+1];
	    cnt = 1;
	    dfsFn(R);
	    StringBuilder sb = new StringBuilder();
	    for (int i=0; i<visited.length; i++){
	      if (i != 0) sb.append(visited[i]).append("\n");
	    }
	    System.out.print(sb);
	    
	  }
	  
	  public static void dfsFn(int R){
	    visited[R] = cnt;
	    if (map.get(R) != null){
	      for (int i=0; i<map.get(R).size(); i++){
	        if (visited[map.get(R).get(i)] == 0){
	            cnt++;
	            dfsFn(map.get(R).get(i));
	        }
	      }  
	    }
	    
	    
	  }
}
