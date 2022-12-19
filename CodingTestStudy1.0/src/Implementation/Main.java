package Implementation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fun(N));
	}
	
	static int fun(int num) {
		int cnt = 0;
		
		int first, second, third = 0;
	
		if (num < 100) return num;
		else {
			cnt = 99;
		
			for (int i=100; i <= num; i++) {
				third = i % 10;
				second = (i / 10) % 10;
				first = i / 100;
				
				if((third - second) == (second - first)) cnt++;
				
			}
		}
		return cnt;
	}
	
}

	


