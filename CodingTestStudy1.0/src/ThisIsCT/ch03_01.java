package ThisIsCT;

import java.io.*;
import java.util.*;

public class ch03_01 {
	// Ch.03 그리디
	// 예제 3-1. 숫자 카드 게임
	
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		int max = -99;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr[i]);
			if (max < arr[i][0]) max = arr[i][0];
		}
		
		
		System.out.println(max);


	}

}
