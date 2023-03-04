package Implementation;

import java.io.*;
import java.util.*;

public class Problem2444 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int cnt = 1;
		int cnt2 = 1;
		int index = 2*N-1;
		
		for (int a=0; a < index; a++) {
			sb.setLength(0);
			if (cnt < index) {
				for (int i=0; i<N; i++) {
					if (i < N-cnt) {
						sb.append(" ");
					} else {
						sb.append("*");
					}
				}
				sb.append("\n");
				N++;
				cnt += 2;
				cnt2 = cnt;
			}
			else {
				for (int i=0; i<N; i++) {
					if (i < N-cnt2) {
						sb.append(" ");
					} else {
						sb.append("*");
					}
				}
				sb.append("\n");
				N--;
				cnt2 -= 2;
			}
			System.out.print(sb);
		}
	}
}
