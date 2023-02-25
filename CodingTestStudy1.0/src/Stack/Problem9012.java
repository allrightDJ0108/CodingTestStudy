package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9012 {
	//230225 푸는중
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.parseInt(br.readLine());
	    
	    //String[] stack = new String[50];
	    
	    StringTokenizer st;
	    for (int i=0; i<T; i++) {
	    	st = new StringTokenizer(br.readLine(), "");
	    	String result = "NO";
	    	int rcnt = 0;
	    	int lcnt = 0;
	    	int openYn = 0;
	    	
    		String str = st.nextToken();
    		String[] stack = str.split("");
    		
    		for (int j=0; j<stack.length; j++) {
    			if (stack[j].equals("(")) {
	    			lcnt++;
	    			if (openYn == 0) openYn = 1;
	    			else result = "NO";
	    		} else {
	    			rcnt++;
	    			if (openYn == 1) openYn = 0;
	    		}
    			System.out.println(openYn);
    		}
	    		
	    	if (openYn == 0) {
	    		if (rcnt == lcnt) result = "YES";
	    	}
	    	System.out.println(result);
	    }
	    
	}
}
