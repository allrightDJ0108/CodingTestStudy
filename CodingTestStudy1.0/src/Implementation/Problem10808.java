package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		int[] result = new int[26];
		//a = 97부터
		
		for (int i=0; i<arr.length; i++) {
			result[arr[i] - 97] += 1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<result.length; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}
