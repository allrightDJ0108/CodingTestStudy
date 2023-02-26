package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem1874 {
	//다정 풀이 방식(정답) - StringBuilder이용한 방법
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();


	    int n = Integer.parseInt(br.readLine());
	    int[] arr = new int[n];
	    for (int i=0; i<arr.length; i++){
	      arr[i] = Integer.parseInt(br.readLine());
	    }

	    Stack<Integer> stack = new Stack<>();
	    int index = 0;
	    int i = 0;
	    int point = 0;
	    while(i < n){
	      String check = "";
	      
	      if (!stack.isEmpty() && stack.peek() > arr[i]){
	        check = "NO";
	        sb.setLength(0);
	        sb.append(check);
	        break;
	      } else if (!stack.isEmpty() && stack.peek() == arr[i]){
	        stack.pop();
	        check = "-";
	        point = Math.max(index, point);
	        i++;
	        index = point;
	      
	      } else {
	        index++;
	        stack.push(index);
	        check = "+";
	        
	        
	      }
	      sb.append(check).append("\n");
	   
	      
	    }
		  System.out.println(sb);

	  }
}
