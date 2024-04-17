import java.io.*;
import java.util.*;

public class Main {
	
	static int n, x, y, m;
	static ArrayList<Integer>[] list;
	static Queue<Integer> q = new LinkedList<>();
	static int[] visited;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        
        n = Integer.parseInt(br.readLine());
        
        str = new StringTokenizer(br.readLine());
        x = Integer.parseInt(str.nextToken());
        y = Integer.parseInt(str.nextToken());
        
        m = Integer.parseInt(br.readLine());
        
        list = new ArrayList[n+1];
        visited = new int[n+1];
        for (int i=0; i<n+1; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for (int i=0; i<m; i++) {
        	str = new StringTokenizer(br.readLine());
        	int tx = Integer.parseInt(str.nextToken());
        	int ty = Integer.parseInt(str.nextToken());
        	
        	list[tx].add(ty);
        	list[ty].add(tx);
        }
        
        family();
        
        int answer = visited[y];
        if (answer == 0) answer = -1;
        System.out.println(answer);
        
    }
    
    static void family() {
    	q.add(x);
    	visited[x] = 0;
    	
    	while (!q.isEmpty()) {
    		int cur = q.poll();
    		
    		if (cur == y) break;
    		
    		for (int next : list[cur]) {
    			if (visited[next] == 0) {
    				q.add(next);
    				visited[next] = visited[cur] + 1;
    			}
    		}
    	}
    }
    
}
