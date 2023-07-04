package StudyAlgos;

import java.io.*;
import java.util.*;

public class Problem1074 {
	static int size = 1;
	static int N, r, c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		size = (int) Math.pow(2, N);

		int count = 0;
		int x = 0;
		int y = 0;

		while (size > 0) {
			size /= 2; // 배열을 점점 줄여감
			int nextR = x + size;
			int nextC = y + size;

			// 배열의 시작점
			if (r < nextR && c < nextC) { // 1구역
				count += 0;

			} else if (r < nextR) { // 2구역
				count += size * size;
				y += size;

			} else if (c < nextC) { // 3구역
				count += size * size * 2;
				x += size;

			} else { // 4구역
				count += size * size * 3;
				x += size;
				y += size;
			}

			// 배열이 1*1이 되면 종료
			if (size == 1) {
				System.out.println(count);
				break;
			}
		}

	}
}
