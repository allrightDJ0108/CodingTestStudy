package Implementation;

import java.io.*;
import java.util.*;

public class Problem10174 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for (int x=0; x<N; x++) {
			String str = br.readLine().toLowerCase();
			boolean isPel = true;
			int back = str.length() - 1;
			for (int i=0; i<str.length(); i++, back--) {
				if (str.charAt(i) != str.charAt(back)) {
					isPel = false;
					break;
				}
			}
			if (isPel) System.out.println("Yes");
			else System.out.println("No");
		}
	}
}
