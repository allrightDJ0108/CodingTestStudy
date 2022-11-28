package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem8958 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    	int N = Integer.parseInt(br.readLine());
    	String[] str = new String[N];
    	for (int i=0; i<N; i++) {
    		str[i] = br.readLine();
    	}
    	
    	int result = 0;
    	int score = 0;
    	for (int i=0; i<N; i++) {
    		for (int j=0; j < str[i].length(); j++) {
    			if (str[i].charAt(j) == 'O') {
    				if (score > 0) {
    					result += (1 + score);
    				} else {
    					result += 1;
    				}
    				score += 1;
    			} else {
    				result += 0;
    				score = 0;
    			}
    		}
    		System.out.println(result);
    		result = 0;
        	score = 0;
    	}
    	
	}
}
