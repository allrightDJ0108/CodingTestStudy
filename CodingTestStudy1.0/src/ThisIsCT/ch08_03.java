package ThisIsCT;

import java.io.*;
import java.util.*;

public class ch08_03 {
	// Ch.08 다이나믹 프로그래밍 Dynamic Programming DP
	// 개미 전사
	// 유튜브 풀이 영상 : https://www.youtube.com/watch?v=5Lu34WIx2Us

	static int[] d = new int[100 + 1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		/*
		 * (바로 앞까지의 최적의 해)와
		 * (두칸 앞까지의 최적의 해 + 현재 위치의 해)를 비교하여 더 높은 값을 d[]에 저장함
		 */
		
		
		//0과 1번째는 항상 아래와 같고, 반복문은 2부터(세번째) 돌려줌
		d[0] = arr[0];
		d[1] = Math.max(arr[1], arr[0]);
		for (int i=2; i<N; i++) {
			d[i] = Math.max(d[i-1], d[i-2] + arr[i]);
		}
		
		System.out.println(d[N-1]);
	}
}
