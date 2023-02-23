package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10773 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int K = Integer.parseInt(br.readLine());
	    
	    int[] stack = new int[K];
	    int index = 0;
	    int sum = 0;
	    for (int i=0; i<K; i++) {
	    	int input = Integer.parseInt(br.readLine());
	    	if (input == 0) {
	    		if (index > 0) {
	    			stack[index-1] = 0;
		    		index--;
	    		}
	    	} else {
	    		stack[index] = input;
	    		index++;
	    	}
	    }
	    
	    for (int i=0; i<stack.length; i++) {
	    	sum += stack[i];
	    }
	    System.out.println(sum);
	}
}
