package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5585 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int temp = 1000 - N;
		int cnt = 0;
		
		int[] arr = {500, 100, 50, 10, 5, 1};
		
		for (int i=0; i<arr.length; i++) {
			cnt += temp / arr[i];
			temp = temp % arr[i];
		}
		
		/*
		while(temp > 0 ) {
			if (temp >= 500) {
				cnt += temp / 500;
				temp = temp % 500;
			} else if (temp >= 100) {
				cnt += temp / 100;
				temp = temp % 100;
			} else if (temp >= 50) {
				cnt += temp / 50;
				temp = temp % 50;
			} else if (temp >= 10) {
				cnt += temp / 10;
				temp = temp % 10;
			} else if (temp >= 5) {
				cnt += temp / 5;
				temp = temp % 5;
			} else if (temp >= 1) {
				cnt += temp / 1;
				temp = temp % 1;
			}
			
		}
		*/
		
		System.out.println(cnt);
		
	}
}
