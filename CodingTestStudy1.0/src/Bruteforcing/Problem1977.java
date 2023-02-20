package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1977 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		
		int temp = 0;
		int resultA = 0;
		int resultB = 10000;
		
		for (int i=1; i<=100; i++) {
			temp = i * i;
			if (temp >= A && temp <= B) {
				resultA += temp;
				resultB = Math.min(resultB, temp);
			}
			
		}
		
		if (resultA == 0) {
			resultA = -1;
			System.out.println(resultA);
		} else {
			System.out.println(resultA);
			System.out.println(resultB);
		}
		
	}
}
