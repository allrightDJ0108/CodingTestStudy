package ThisIsCT;

import java.io.*;
import java.util.*;

public class ch03_02 {
	// Ch.03 그리디
	// 예제 3-2. 1이 될 때까지

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int cnt = 0;
		while (N > 1) {
			
			if (N % K == 0) {
				N /= K;
				cnt++;
			} else {
				N -= 1;
				cnt++;
			}
			
			if (N == 1) {
				break;
			}
			
		}
		
		System.out.println(cnt);
		
	}

}