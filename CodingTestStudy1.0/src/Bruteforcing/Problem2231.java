package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		System.out.println(func(N));
	}
	
	static int func(int N) {
		
		int num = 1;
		while (num < N) {
			int sum = num;
			int temp = num;
			
			while(true) {
				sum += temp % 10;
				temp = temp / 10;
				if (temp==0) {
					break;
				}
			}
			if (sum == N) {
				return num;
			} else {
				num++;
			}
		}
		return 0;
		
	}
}
