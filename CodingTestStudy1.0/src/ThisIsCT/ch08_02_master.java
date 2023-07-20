package ThisIsCT;

import java.io.*;

public class ch08_02_master {
	//Ch.08 다이나믹 프로그래밍 Dynamic Programming DP
	// 1로 만들기
	
	static int[] d = new int[30000+1];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		//보텀업 방식
		//X부터 시작하는게 아니라 가장 낮은 숫자(2)부터 시작
		//d[]는 연산 횟수임
		for (int i=2; i <= X; i++) {
			d[i] = d[i-1] + 1;
			if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
		}
		
		
		System.out.println(d[X]);
	}
	
}
