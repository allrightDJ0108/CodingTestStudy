package ThisIsCT;

import java.io.*;
import java.util.*;

public class ch08_05 {
	// Ch.08 다이나믹 프로그래밍 Dynamic Programming DP
	// 효율적인 화폐 구성
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());

		int[] arr = new int[N+1];		//화폐의 단위 저장 배열
		int[] R = new int[M+1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//M의 최대값 10000보다 1이 큰 수(절대 나올 수 없는 수로 초기화)
		Arrays.fill(R, 100001);
		/*
		for (int i=0; i<M+1; i++) {
			R[i] = 100001;		
		}
		*/
		
		R[0] = 0;
		for (int i=0; i<N; i++) {
			//사용할 화폐의 단위 선택
			int temp = arr[i];
			
			for (int j=temp; j<M+1; j++) {
				//j : 나타내고자 하는 금액
				if (R[j-temp] != 100001) {
					R[j] = Math.min(R[j], R[j-temp] + 1);
				}
			}
		}
		
		if (R[M] == 100001) {
			System.out.println(-1);
		} else {
			System.out.println(R[M]);
		}
		
	}
}
