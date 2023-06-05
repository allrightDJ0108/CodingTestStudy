package Queue;

import java.util.*;
import java.io.*;

public class Problem1966 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int tc = 0;
		while (tc++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<Integer> q = new LinkedList<>();
			Queue<Integer> qIndex = new LinkedList<>();
			int cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				int x = Integer.parseInt(st.nextToken());
				q.add(x);
				qIndex.add(i);
			}
			
			while (!q.isEmpty()) {
				int max = Collections.max(q);
				int cur = q.poll();
				int curIndex = qIndex.poll();
				
				if (cur == max) {
					cnt++;
					if (curIndex == M) {
						System.out.println(cnt);
						break;
					}
				} else {
					q.add(cur);
					qIndex.add(curIndex);
				}
				
			}
			
		}
	}

}
