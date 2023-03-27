package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem2967_new {
	// 230327 복습
	// 마크된 부분은 틀렸던 부분
	static int N, K;
	static int result = 0;
	static Queue<Integer> q = new LinkedList<>();
	static int[] arr = new int[100001]; // 여기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N != K)
			bfsFn();
		System.out.println(result);

	}

	static void bfsFn() {
		q.add(N);
		arr[N] = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 0; i < 3; i++) {
				int next = 0; // 이거 for문 밖에다 함

				if (i == 0) {
					next = cur - 1;
				} else if (i == 1) {
					next = cur + 1;
				} else {
					next = cur * 2;
				}

				if (next == K) {
					result = arr[cur]; // 여기서 arr[NEXT]로 함
					return;
				}

				if (next >= 0 && next < arr.length && arr[next] == 0) { // 여기 arr[next] == 0 조건 누락
					q.add(next);
					arr[next] = arr[cur] + 1; // 잘했당!
				}
			}

		}

	}
}
