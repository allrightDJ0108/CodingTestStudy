package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		int A = Integer.parseInt(str[0]);
		int B = Integer.parseInt(str[1]);
		int V = Integer.parseInt(str[2]);
		
		//A * x - B(x - 1) = V
		int x = (V - B) / (A - B);
		//정점 도달 시 미끄러지지 않음
		if ((V - B) % (A - B) != 0) x++;
		System.out.println(x);
		
		
	}
}
