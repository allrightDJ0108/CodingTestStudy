package Stack;

import java.util.*;
import java.io.*;

public class Problem10828 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    int[] stack = new int[N];
	    int index = 0;
	    int in = 0;
	    
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    
	    while (index < N) {
	    	st = new StringTokenizer(br.readLine());
	    	String order = st.nextToken();
	    	
	    	if (order.equals("push")) {
	    		stack[in] = Integer.parseInt(st.nextToken());
	    		in++;
	    		
	    	} else if (order.equals("pop")) {
	    		if ( in > 0 ) {
	    			sb.append(stack[in-1]).append("\n");
	    			stack[in-1] = 0;
	    			in--;
	    		} else if (in == 0) {
	    			sb.append(-1).append("\n");
	    		}
	    		
	    	} else if (order.equals("size")) {
	    		sb.append(in).append("\n");
	    		
	    	} else if (order.equals("empty")) {
	    		if (in > 0) {
	    			sb.append(0).append("\n");
	    		} else {
	    			sb.append(1).append("\n");
	    		}
	    		
	    	} else if (order.equals("top")) {
	    		if (in > 0) {
	    			sb.append(stack[in-1]).append("\n");
	    		} else {
	    			sb.append(-1).append("\n");
	    		}
	    		
	    	}
	    	
	    	index++;
	    }
	    System.out.println(sb);
	}
}
