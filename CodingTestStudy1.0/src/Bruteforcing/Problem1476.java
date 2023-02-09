package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1476 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(str.nextToken());
		int S = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		int a = 1; int b = 1; int c = 1; int year = 1;
		while (true) {
			
			if (a == E && b == S && c == M) {
				System.out.println(year);
				return;
			} else year++;
			
			if (a >= 15) a = 1; else a++;
			if (b >= 28) b = 1; else b++;
			if (c >= 19) c = 1; else c++;
			
			//System.out.println(a +" "+ b+" " + c);
		}
	}
}
