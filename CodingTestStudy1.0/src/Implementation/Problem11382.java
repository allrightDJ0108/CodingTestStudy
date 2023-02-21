package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11382 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer str = new StringTokenizer(br.readLine());
	    
	    long sum = 0;
	    for (int i=0; i<3; i++) {
	    	sum += Long.parseLong(str.nextToken());
	    }
	    System.out.println(sum);
	}
}
