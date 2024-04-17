import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] list;
	static int[] visited;
	static Queue<Integer> q = new LinkedList<>();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        
        visited = new int[N+1];
        list = new ArrayList[N+1];
        for (int i=0; i<N+1; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for (int i=0; i<N-1; i++) {
        	str = new StringTokenizer(br.readLine());
        	
        	int x = Integer.parseInt(str.nextToken());
        	int y = Integer.parseInt(str.nextToken());
        	
        	list[x].add(y);
        	list[y].add(x);
        }
        
        q.add(1);
        visited[1] = 0;
        
        while (!q.isEmpty()) {
        	int cur = q.poll();
        	
        	for (int next : list[cur]) {
        		if (visited[next] == 0) {
        			q.add(next);
        			visited[next] = cur;
        		}
        	}
        }
        
        for (int i=2; i<N+1; i++) {
        	sb.append(visited[i]).append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    
}
