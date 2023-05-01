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
		
		for (int i=0; i<10; i++) {
			N = Integer.parseInt(br.readLine());
			prevSum = sum;
			sum += N;
			
			if (Math.abs(prevSum - 100) < Math.abs(sum - 100)) {
				sum = prevSum;
				break;
			}
		}
		
		System.out.println(sum);
	}
}
