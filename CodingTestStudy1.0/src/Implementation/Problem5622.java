package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5622 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		char[] arrCh = str.toCharArray();
		
		int sum = 0;
		for (int i=0; i < arrCh.length; i++) {
			int N = arrCh[i];
			if ( N >= 65 && N < 68 ) {			//A ~ C	2
				sum += 3;
			} else if ( N >= 68 && N < 71 ) {	//D ~ F	3
				sum += 4;
			} else if ( N >= 71 && N < 74 ) {	//G ~ I	4
				sum += 5;
			} else if ( N >= 74 && N < 77 ) { 	//J ~ L	5
				sum += 6;
			} else if ( N >= 77 && N < 80 ) {	//M ~ O	6
				sum += 7;
			} else if ( N >= 80 && N < 84 ) {	//P ~ S	7
				sum += 8;
			} else if ( N >= 84 && N < 87 ) {	//T ~ V	8
				sum += 9;
			} else if ( N >= 87 && N < 91 ) {	//W ~ Z	9
				sum += 10;
			}
			
		}
		
		System.out.println(sum);
		
	}
}
