package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10807 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] str = br.readLine().split(" ");
		
		int v = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for (int i=0;i<str.length;i++) {
			if (Integer.parseInt(str[i]) == v) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
