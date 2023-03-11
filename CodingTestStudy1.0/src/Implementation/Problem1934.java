package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1934 {
	//유클리드 호제법 이용
	//[A * B / 최대공약수 = 최소공배수]를 이용하기 위해 최대공약수부터 구함
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer str;
		for (int i=0; i<T; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(str.nextToken());
			int B = Integer.parseInt(str.nextToken());
			
			System.out.println(A * B / gcd(A,B));
		}
	}
	
	//최대공약수 구하는 함수
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a%b);		//재귀를 이용한 최대공약수 구하기
	}
}
