package Queue;

import java.io.*;
import java.util.*;

public class Problem1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();

		StringTokenizer str = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());

		str = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			q.add(Integer.parseInt(str.nextToken()));
		}

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			int qCur = q.poll();
			
			if (list.indexOf(qCur) <= list.size() / 2) {
				while(qCur != list.getFirst()) {
					int dqCur = list.removeFirst();
					list.add(dqCur);
					cnt++;
				}
			} else {
				while(qCur != list.getFirst()) {
					int dqCur = list.removeLast();
					list.addFirst(dqCur);
					cnt++;
				}
			}
			list.remove();	//첫번째 값 제거
		}
		System.out.println(cnt);
	}

}