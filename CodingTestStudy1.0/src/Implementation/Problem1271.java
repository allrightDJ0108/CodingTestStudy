package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem1271 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		BigInteger N = new BigInteger(str.nextToken());
		BigInteger M = new BigInteger(str.nextToken());
		
		/*
		BigInteger.add() 		: 더하기
		BigInteger.subtact() 	: 빼기 
		BigInteger.multiply() 	: 곱하기 
		BigInteger.divide() 	: 몫 구하기 
		BigInteger.mod() 		: 나머지 구하기
		*/
		
		System.out.println(N.divide(M));
		System.out.println(N.mod(M));
	}
}
