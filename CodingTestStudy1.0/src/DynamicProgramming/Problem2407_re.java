package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem2407_re {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(str.nextToken());
		int R = Integer.parseInt(str.nextToken());
		
		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;
		
		for (int i=0; i<R; i++) {
			n1 = n1.multiply(new BigInteger(String.valueOf(N-i)));		//nPr
			n2 = n2.multiply(new BigInteger(String.valueOf(i+1)));		//r!
		}
		
		System.out.println(n1.divide(n2));
	}
}
