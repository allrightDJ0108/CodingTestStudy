package DynamicProgramming;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Problem2407 {
	
	static BigInteger[][] bi = new BigInteger[100+1][100+1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());

		BigInteger sum = BigInteger.ONE;
		BigInteger div = BigInteger.ONE;

		for (int i = 0; i < M; i++) {
			sum = sum.multiply(new BigInteger(String.valueOf(N - i)));
			div = div.multiply(new BigInteger(String.valueOf(i + 1)));
		}

		System.out.println(sum.divide(div));
		dpFunc(N,M);			//DP를 이용한 풀이

	}

	
	static void dpFunc(int N, int M) {
		for (int i=1;i <= N; i++) {
			for (int j=0; j <= i; j++) {
				if (j==0 || j == i) {
					bi[i][j] = BigInteger.ONE;
				} else {
					bi[i][j] = bi[i-1][j].add(bi[i-1][j-1]);
				}
			}
		}
		
		System.out.println(bi[N][M]);
	}
}