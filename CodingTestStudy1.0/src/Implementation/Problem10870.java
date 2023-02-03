package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(func(n));
	}
	
	static int func(int n) {
		int sum = 0;
		if (n >= 2) {
			sum += func(n-1)+func(n-2);
		} else {
			sum += n;
		}
		
		return sum;
	}

}
