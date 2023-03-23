package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem1697 {
	
	static Queue<Integer> q = new LinkedList<>();
	static int[] arr = new int[100000];
	static int result = 0;
	static int N, K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (N != K) bfsFn(N);
		System.out.println(result);
		
	}
	
	static void bfsFn(int N) {
		q.add(N);
		arr[N] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i=0; i<3; i++) {
				int next = 0;
				
				if (i==0) 		next = cur - 1;
				else if (i==1) 	next = cur + 1;
				else 			next = cur * 2;
				
				if (next == K) {
					result = arr[cur];
					return;
				}
				
				if (next >= 0 && next < arr.length && arr[next] == 0) {
					q.add(next);
					arr[next] = arr[cur] + 1;
				}
				
			}
		}
		
	}
}
