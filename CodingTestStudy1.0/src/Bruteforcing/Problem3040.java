package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3040 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		
		for (int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int x = 0;
		int y = 0;
		
		for (int i=0; i<9; i++) {
			for (int j=i+1; j<9; j++) {
				int sum = 0;
				int index = 0;
				while(index < 9) {
					if ( index != i && index != j ) {
						sum += arr[index];
					}
					index++;
				}
				if (sum == 100) {
					x = arr[i];
					y = arr[j];
				}
			}
			
		}
		
		StringBuilder str = new StringBuilder();
		for (int i=0; i<9; i++) {
			if (arr[i] != x && arr[i] != y ) {
				str.append(arr[i]).append("\n");
			}
		}
		System.out.println(str);
		
		
	}
}
