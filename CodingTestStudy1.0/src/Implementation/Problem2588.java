package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2588 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		
		int num = 0;
		int res = B;
		for (int i=0;i<3;i++) {
			num = B % 10;
			B /= 10;
			System.out.println(A*num);
		}
		System.out.println(A*res);
		
	}
}
