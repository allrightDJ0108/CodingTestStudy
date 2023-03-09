package Implementation;

import java.io.*;
import java.util.*;

public class Problem10953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer str;
		StringBuilder sb = new StringBuilder();
		int a = 0;
		int b = 0;
		for (int i=0; i<T; i++) {
			str = new StringTokenizer(br.readLine(), ",");
			a = Integer.parseInt(str.nextToken());
			b = Integer.parseInt(str.nextToken());
			sb.append(a+b).append("\n");
		}
		
		System.out.println(sb);
	}
}
