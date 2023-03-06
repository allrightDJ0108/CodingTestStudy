package Queue;

import java.io.*;
import java.util.*;

public class Problem11866_new {
	//큐(LinkedList)로 풀기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i=0; i<N; i++) {
			queue.add(i+1);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!queue.isEmpty()) {
			
			for(int i = 0; i < K - 1; i++) {
				//맨 앞의 원소를 꺼내(poll) 맨 뒤로 넣는다(offer)
				queue.offer(queue.poll());
			}
			sb.append(queue.poll());
			if (queue.size() != 0) sb.append(", ");
		}
		
		
		sb.append(">");
		System.out.println(sb);
		
		
	}
}
