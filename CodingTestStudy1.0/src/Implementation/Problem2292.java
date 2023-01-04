package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 1;
		int sum = 2;
		
		if (N == 1) {
			cnt = 1;
		}
		else {
			while (sum <= N) {
				sum += 6 * cnt;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
