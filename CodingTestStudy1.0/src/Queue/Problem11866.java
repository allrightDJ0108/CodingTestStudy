package Queue;

import java.io.*;
import java.util.*;

public class Problem11866 {
	//리스트로 풀기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		//배열로 풀다가 대실패!
		//int[] queue = new int[N];
		ArrayList<Integer> queue = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			queue.add(i+1);
		}
		
		int index = K - 1;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!queue.isEmpty()) {
			if (index >= queue.size()) index = index % queue.size();
			sb.append(queue.get(index));
			queue.remove(index);
			index += K - 1;
			if (queue.size() != 0) sb.append(", ");
		}
		
		
		sb.append(">");
		System.out.println(sb);
		
		
	}
}
