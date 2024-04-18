import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
        	String input = br.readLine();
        	String[] arr = input.split(" ");
        	StringBuilder sb = new StringBuilder();
        	
        	while(true) {
        		StringTokenizer str = new StringTokenizer(br.readLine());
        		String animal = str.nextToken();
        		if (animal.equals("what")) break;
        		String goes = str.nextToken();
        		String say = str.nextToken();
        		
        		for (int i=0; i<arr.length; i++) {
        			if (arr[i].equals(say)) arr[i] = "";
        		}
        	}
        	
        	for (int i=0; i<arr.length; i++) {
    			if (!arr[i].equals("")) sb.append(arr[i]+" ");
    		}
        	
        	System.out.println(sb);
        }
        
    }
    
}
