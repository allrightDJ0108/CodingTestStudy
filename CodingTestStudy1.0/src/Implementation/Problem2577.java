package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2577 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    	int A = Integer.parseInt(br.readLine());
    	int B = Integer.parseInt(br.readLine());
    	int C = Integer.parseInt(br.readLine());
    	
    	int[] num = new int[10];
    	
    	int result = A*B*C;
    	while (result > 0) {
    		num[result % 10] += 1;
    		result /= 10;
    		//System.out.println(result % 10 +" "+result);
    	}
    	
    	for (int i=0;i< num.length;i++) {
    		System.out.println(num[i]);
    	}
    	
	}
}
