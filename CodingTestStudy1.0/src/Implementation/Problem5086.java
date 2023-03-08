package Implementation;

import java.io.*;
import java.util.*;

public class Problem5086 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken());
			if (N==0 && M==0) break;
			
			if (N < M) {
				if (M % N == 0) bw.write("factor");
				else bw.write("neither");
			} else {
				if (N % M == 0) bw.write("multiple");
				else bw.write("neither");
			}
			bw.newLine();
			
		}
		
		bw.flush();
		bw.close();
	}
}
