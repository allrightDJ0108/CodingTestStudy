package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1008 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double[] num = new double[2];
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		for (int i=0;i<num.length;i++) {
			num[i] = Double.parseDouble(str.nextToken());
		}
		System.out.println(num[0]/num[1]);
	}
}
