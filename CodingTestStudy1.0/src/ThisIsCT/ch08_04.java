package ThisIsCT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch08_04 {
	// Ch.08 다이나믹 프로그래밍 Dynamic Programming DP
	// 바닥 공사
	
	static int[] d = new int[1000 + 1];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		/*
		 * 1) 왼쪽부터 i-1까지 덮개로 채워지면 2 * 1의 덮개로 채울 수 있음 -> 한가지
		 * 2) 왼쪽부터 i-2까지 덮개로 채워지면 2 * 2 또는 1 * 2의 덮개로 채울 수 있음 -> 두가지
		 * 
		 */
		
		d[1] = 1;
		d[2] = 3;
		for (int i=3; i<N+1; i++) {
			d[i] = (d[i - 1] + d[i - 2] * 2) % 796796;
		}
		System.out.println(d[N]);
	}
}
