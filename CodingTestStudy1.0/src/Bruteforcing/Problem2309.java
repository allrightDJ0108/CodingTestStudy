package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[9];
		int sum = 0;
		for (int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		for (int a=0; a<arr.length - 1; a++) {
			for (int b=a+1; b<arr.length; b++) {
				if ((sum - arr[a] - arr[b]) == 100) {
					arr[a] = 0;
					arr[b] = 0;
					Arrays.sort(arr);
					for (int i=0; i<9; i++) {
						if (arr[i] != 0) sb.append(arr[i]).append("\n");
					}
					System.out.println(sb);
					return;
				}
				
			}
		}
	}
}
