package Queue;

import java.io.*;
import java.util.*;

public class Problem1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dq = new LinkedList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();

		StringTokenizer str = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());

		str = new StringTokenizer(br.readLine());

		for (int i=0; i<M; i++) {
			q.add(Integer.parseInt(str.nextToken()));
		}

		for (int i=1; i<=N; i++) {
			dq.add(i);
		}

		int cnt = 0;
		while(!q.isEmpty()) {
			int qCur = q.poll();
			int dqCur = dq.pollFirst();
			if (qCur != dqCur) {
				dq.addLast(dqCur);
				cnt++;
			}
		}
		System.out.println(cnt);
	}


}
