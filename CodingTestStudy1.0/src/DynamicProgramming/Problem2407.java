package DynamicProgramming;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Problem2407 {

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

	}

}