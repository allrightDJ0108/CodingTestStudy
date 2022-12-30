package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int sum = 0;
		for (int i=0; i < str.length();i++) {
			//charAt은 아스키코드 문자기 때문에, '0'(48)을 빼줘서 정수로 맞춤
			sum += str.charAt(i) - '0';
		}
		
		System.out.println(sum);
	}
}
