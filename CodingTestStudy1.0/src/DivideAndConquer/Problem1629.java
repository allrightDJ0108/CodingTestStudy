package DivideAndConquer;

import java.io.*;
import java.util.*;

public class Problem1629 {
	
	static long C;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		long A = Long.parseLong(str.nextToken());
		long B = Long.parseLong(str.nextToken());
		C = Long.parseLong(str.nextToken());
		
		
		/*
		(A ^ B) % C
		(A * A) % C
		=> ((A % C) * (A % C)) % C
		 * 
		 */
		
		
		//System.out.println( Math.pow(A, B) % C);
		System.out.println(powFunc(A, B));
	}
	
	static long powFunc(long A, long B) {
		
		if (B == 1) {
			return A % C;
		}
		
		/* 지수의 법칙 사용
		 * A^(N+M) = A^N * A*M
		 * A^8 	= (A^4) * (A^4)
		 * 		= (A^2) * (A^2) * (A^2) * (A^2)
		 * 		= ((A^1) * (A^1)) * ((A^1) * (A^1)) * ((A^1) * (A^1)) * ((A^1) * (A^1))
		 */
		long temp = powFunc(A, B / 2);
		
		//지수가 홀수인 경우 		(A^B/2) * (A^B/2) * A
		/*	모듈러 합동 공식 사용
		 * (temp * temp * A) % C 
		 * 			= (( temp * temp % C) * (A % C)) % C
					= (((temp * temp % C) % C) * (A % C)) % C 	// (temp * temp % C) = (temp * temp % C) % C
					= (( temp * temp % C) * A) % C
		 */
		if (B % 2 == 1) return (temp * temp % C) * A % C;
		
		return temp * temp %  C;
	}

}
