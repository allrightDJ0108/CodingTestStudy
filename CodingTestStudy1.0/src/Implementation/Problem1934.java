package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1934 {
	//다정 푸는중
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer str;
		for (int i=0; i<T; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(str.nextToken());
			int B = Integer.parseInt(str.nextToken());
			
			int result = 0;
			
			if (A == 1) {
				result = B;
			} else if (B == 1) {
				result = A;
			} else {
				System.out.println("%%");
				result = A*B;
				for (int a=1; a<=result; a++) {
					for (int b=1; b<=result; b++) {
						if (A * a == B * b) {
							result = A * a;
							break;
						}
					}
				}
			}
			
			System.out.println(result);
		}
	}
}
