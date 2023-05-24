package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13458 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] A = new long[st.countTokens()];
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		long result = 0;
		for (int i = 0; i < N; i++) {
			long a = A[i];
			if (a - B > 0) {
				a = a - B;
				result = result + a / C;
				if (a % C != 0) {
					result++;
				}
			}
			result++;

		}
		System.out.println(result);
	}
}
