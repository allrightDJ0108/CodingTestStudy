package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9086 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			String str  = br.readLine();
			System.out.print(str.charAt(0));
			System.out.println(str.charAt(str.length()-1));
		}
	}
}
