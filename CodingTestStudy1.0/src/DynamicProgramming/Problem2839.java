package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2839 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] d = new int [5000+1];
		
		Arrays.fill(d,5001);
		
		d[3] = 1;
		d[5] = 1;
		
		for (int i=6; i<N+1; i++) {
			if (i % 5 == 0) {
				d[i] = d[i - 5] + 1;
			} else if (i % 3 == 0) {
				d[i] = d[i - 3] + 1;
			} else {
				if (d[i - 3] != 0 && d[i - 5] != 0) {
					d[i] = Math.min(d[i-3], d[i-5]) + 1;
				}
			}
		}
		
		if (d[N] == 5001) {
			System.out.println(-1);
		} else {
			System.out.println(d[N]);
		}
	}

}
