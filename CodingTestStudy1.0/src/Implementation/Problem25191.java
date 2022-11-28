package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem25191 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    	int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cnt = 0;
		
		String[] array = str.split(" ");
		cnt += Integer.parseInt(array[0]) / 2;
		cnt += Integer.parseInt(array[1]);
		if (cnt > N) cnt = N;
		
		System.out.println(cnt);
	}
}
