package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int num = 665;
		int cnt = 0;
	
		while(true) {
			if (cnt == N) {
				break;
			} else {
				num++;
			}
			
			if (String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(num);
		
		//처음에 접근했던 노답 방식,,^^;
		/*
		while(cnt < N) {
			String[] str = String.valueOf(num).split("");
			
			for(int i=0; i < str.length; i++) {
				if (str[str.length - 1].equals("6")) {
					System.out.println(num);
				}
			}
			num++;
			cnt++;
			
		}
		*/
		
	}
	
}
