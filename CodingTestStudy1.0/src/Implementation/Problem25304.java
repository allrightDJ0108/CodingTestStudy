package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem25304 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		String str = "";
		String[] item = new String[2];
		int sum = 0;
		
		for (int i=0;i<N; i++) {
			str = br.readLine();
			item = str.split(" ");
				
			sum += Integer.parseInt(item[0]) * Integer.parseInt(item[1]);
		}
		
		System.out.println(sum == X ? "Yes" : "No");
	}
}
