package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem4949 {
	//다정 풀이 방식
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    while(true){
	      String str = br.readLine();

	      //테스트케이스 시작
	      String result = "no";
	      Stack<Character> stack = new Stack<>();
	      for (int i=0; i<str.length(); i++){
	        if (str.charAt(i) == '('){
	          stack.push('(');
	        } else if (str.charAt(i) == ')'){
	          if (stack.isEmpty() || stack.peek() != '('){
	            stack.push('(');
	            break;
	          } else {
	            stack.pop();            
	          }          
	        } else if (str.charAt(i) == '['){
	          stack.push('[');
	        } else if (str.charAt(i) == ']'){
	          if (stack.isEmpty() || stack.peek() != '['){
	            stack.push('[');
	            break;
	          } else {
	            stack.pop();            
	          }
	          
	        }
	      }

	      if (stack.isEmpty()) result = "yes";
	      //테스트케이스 종료

	      if (str.equals(".")){
	        break;
	      } else {
	        System.out.println(result);
	      }
	    }
	      
		    
	  }
}
