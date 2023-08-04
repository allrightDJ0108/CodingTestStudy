package Softeer;

import java.io.*;

public class lv2_413 {
	//지도 자동 구축
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		double dp[] = new double[N+1];		//점의 개수 저장
		
		for (int i=0; i<N+1; i++) {
			 //사각형의 개수(행 기준) : 1, 2, 4, 8, 16, ...
			//점의 개수 : (사각형의 개수 + 1) ^ 2
			dp[i] = Math.pow(2,i) + 1;
		}
		
		//출력할 값만 ^2처리 해줌
		double result = Math.pow(dp[N], 2);
		//.0 제거를 위한 반올림 처리
		System.out.println(Math.round(result));
	}
}
