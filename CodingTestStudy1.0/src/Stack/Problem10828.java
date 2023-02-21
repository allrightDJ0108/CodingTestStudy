package Stack;

import java.util.*;
import java.io.*;

public class Problem10828 {
	//푸는중
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int N = Integer.parseInt(br.readLine());
	    int index = 0;
	    Map<Integer, Integer> sta = new HashMap<Integer, Integer>();

	    int in = 0;
	    
	    StringTokenizer str;
	    while(index < N){
	      str = new StringTokenizer(br.readLine());
	      String order = str.nextToken();
	      StringBuilder sb = new StringBuilder();
	      
	      if (order.equals("push") ) {
	        sta.put(in, Integer.parseInt(str.nextToken()));
	        in++;
	        
	      } else if (order.equals("pop") ) {
	        if (in > 0){
	          sb.append(sta.get(in-1));
	          sta.put(in, null);
	          in--;
	        } else if (in == 0){
	        		sta.put(in, null);
	        		sb.append(-1);
	          
	        } else {
	          sb.append(-1);
	        }
	        
	      } else if (order.equals("size") ) {
	        sb.append(in);
	        
	      } else if (order.equals("empty") ) {
	        if (in > 0) sb.append(0); 
	        else sb.append(1); 
	      
	      } else if (order.equals("top") ) {
	        if (in > 0) sb.append(sta.get(in-1)); 
	        else sb.append(-1); 
	        
	      }
	      //sb.append("\n");
	      System.out.println(sb);
	      index++;    
	    }
	    
	    }
}
