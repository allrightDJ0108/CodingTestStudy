package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
		int start = 0;
		int end = arr.length-1;
		int mid = arr.length / 2;
		/*
		if ( arr.length % 2 != 0 ) {
			mid = arr.length / 2 + 1;
		}
		*/
		
		int result = 0;
		while (start < end) {
			if (arr[start] == arr[end]) {
				result++;
			}
			start++; end--;
		}
		if (mid == result) System.out.println(1);
		else System.out.println(0);
	}
}
