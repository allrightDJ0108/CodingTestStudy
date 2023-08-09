package BinarySearch;

import java.io.*;

public class Problem1789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		int result = 1;
		
		for (int i=0; i < S; i++) {
			sum += i;
			if (sum > S) {
				result = i - 1;
				break;
			}
			if (sum == S) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
		
	}
}
