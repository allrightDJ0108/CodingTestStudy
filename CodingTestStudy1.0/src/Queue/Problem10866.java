package Queue;

import java.io.*;
import java.util.*;

public class Problem10866 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		while( N-- > 0 ) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if (("push_front").equals(order)) {
				int x = Integer.parseInt(st.nextToken());
				dq.addFirst(x);
				
			} else if (("push_back").equals(order)) {
				int x = Integer.parseInt(st.nextToken());
				dq.addLast(x);
				
			} else if (("pop_front").equals(order)) {
				if (dq.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dq.pollFirst()).append("\n");
				}
				
			} else if (("pop_back").equals(order)) {
				if (dq.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dq.pollLast()).append("\n");
				}
				
			} else if (("size").equals(order)) {
				sb.append(dq.size()).append("\n");
				
			} else if (("empty").equals(order)) {
				if (dq.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				
			} else if (("front").equals(order)) {
				if (dq.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dq.peekFirst()).append("\n");
				}
				
			} else if (("back").equals(order)) {
				if (dq.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dq.peekLast()).append("\n");
				}
				
			}
			
		}
		System.out.println(sb);
	}

}
