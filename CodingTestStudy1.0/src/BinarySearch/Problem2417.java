package BinarySearch;

import java.io.*;
import java.math.*;

public class Problem2417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num = br.readLine();
		BigInteger N = new BigInteger(num);

		BigInteger start = BigInteger.ZERO;
		BigInteger end = N;
		BigInteger min = BigInteger.ZERO;
		
		while (start.compareTo(end) == -1 || start.compareTo(end) == 0) {
			BigInteger sum = start.add(end);
			BigInteger mid = sum.divide(BigInteger.TWO);
			BigInteger result = mid.pow(2);
			
			if (N.compareTo(result) == -1 || N.compareTo(result) == 0) {
				min = mid;
				end = mid.subtract(BigInteger.ONE);
			} else {
				start = mid.add(BigInteger.ONE);
			}
		}
		
		System.out.println(min);
	}
}
