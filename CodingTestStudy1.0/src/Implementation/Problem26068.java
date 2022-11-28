package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem26068 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    	int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		int cnt = 0;
		
		for (int i=0;i<N;i++) {
			str[i] = br.readLine();
		}
		for (int i=0;i<N;i++) {
			if (Integer.parseInt(str[i].substring(2)) <= 90) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
