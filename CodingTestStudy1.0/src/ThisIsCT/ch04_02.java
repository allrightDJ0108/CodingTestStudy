package ThisIsCT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ch04_02 {
		// Ch.04 구현
		// 예제 4-2. 시각

		static int N;
		static int cnt = 0;

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			N = Integer.parseInt(br.readLine());
			func();
			System.out.println(cnt);
		}
		
		static void func() {
			for (int t=0; t<=N; t++) {
				for (int i=0; i<60; i++) {
					for (int j=0; j<60; j++) {
						String temp = Integer.toString(t) +Integer.toString(i) + Integer.toString(j);
						if (temp.contains("3")) cnt++;
					}
				}
			}
		}
}
