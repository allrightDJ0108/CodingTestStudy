package ThisIsCT;

import java.io.*;

public class ch08_02 {
	//Ch.08 다이나믹 프로그래밍 Dynamic Programming DP
	// 1로 만들기
	// 내가 푼 방법
	
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		while (true) {
			
			if (N == 1) {
				break;
			}
			
			if (N % 5 == 0) {
				N = N / 5;
				cnt++;
				continue;
			}
			
			if (N % 3 == 0) {
				N = N / 3;
				cnt++;
				continue;
			}
			
			if (N % 2 == 0) {
				N = N / 2;
				cnt++;
				continue;
			}
			
			N = N - 1;
			cnt++;
			
		}
		
		System.out.println(cnt);
	}
	
}
