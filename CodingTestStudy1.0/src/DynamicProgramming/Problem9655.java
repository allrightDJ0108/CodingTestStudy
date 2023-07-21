package DynamicProgramming;

import java.io.*;

public class Problem9655 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = "";
		// 홀수이면 SK, 짝수이면 CY이인 패턴을 이용해서 처음 풀었던 풀이
		if (N%2 == 0) {
			str = "CY";
		} else {
			str = "SK";
		}
		
		// DP를 이용한 정석적인 풀이
		int[] d = new int[1000 + 1];
		
		d[1] = 1;
		d[2] = 2;
		d[3] = 1;
		for (int i=4; i<N+1; i++) {
			d[i] = Math.min(d[i-1], d[i-3]) + 1;
		}
		
		if (d[N] % 2 == 0) {
			str = "CY";
		} else {
			str = "SK";
		}
		
		
		// 결과 출력
		System.out.println(str);
	}

}
