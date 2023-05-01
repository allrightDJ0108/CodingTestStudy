package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		int sum = 0;
		int prevSum = 0;
		int result = 0;
		
		for (int i=0; i<10; i++) {
			N = Integer.parseInt(br.readLine());
			prevSum = sum;
			sum += N;
			if (sum == 100) {
				result = sum;
				i=99;
			} else if (sum > 100) {
				int a = Math.abs(prevSum - 100);
				int b = Math.abs(sum - 100);
				if (a < b){
					result = prevSum;
				} else if (a == b ) {
					result = sum;
				} else {
					result = sum;
				}
				i=99;
			}
		}
		
		System.out.println(result);
	}
}
