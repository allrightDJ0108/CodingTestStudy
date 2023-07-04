package StudyAlgos;

import java.io.*;
import java.util.*;

public class Problem17829 {

	static int[][] arr;
	static int N, M;
	static int[][] tempArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		func(N);
		System.out.println(arr[0][0]);
	}

	static void func(int N) {

		if (N == 1)
			return;

		tempArr = new int[N / 2][N / 2];

		for (int x = 0; x < N; x += 2) {
			for (int y = 0; y < N; y += 2) {
				int[] temp = { arr[x][y], arr[x][y + 1], arr[x + 1][y], arr[x + 1][y + 1] };
				Arrays.sort(temp); // 오름차순 정렬, 2번째 큰 수의 index는 2

				tempArr[x / 2][y / 2] = temp[2];
			}
		}

		arr = tempArr;

		func(N / 2);
	}
}
