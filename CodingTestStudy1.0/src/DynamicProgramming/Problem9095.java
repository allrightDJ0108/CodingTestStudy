package DynamicProgramming;

import java.io.*;

public class Problem9095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] d = new int[11+1];
			
			d[1] = 1;
			d[2] = 2;
			d[3] = 4;
			
			if (N > 3) {
				for (int i=4; i<N+1; i++) {
					d[i] = d[i-1] + d[i-2] + d[i-3];
				}
			}
			
			System.out.println(d[N]);
		}
	}
}
