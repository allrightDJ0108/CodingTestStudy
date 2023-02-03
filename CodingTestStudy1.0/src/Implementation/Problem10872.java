package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10872 {
	static int result = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		func(N);
	}
	
	static void func(int n) {
		if (n > 0) {
			result = result * n;
			if (n == 1) {
				System.out.println(result);
			} else {
				func(n-1);
			}
		} else {
			System.out.println(result);
		}
		
	}
}
