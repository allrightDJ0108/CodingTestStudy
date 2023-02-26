package Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem1874_new {
	//다정 풀이 방식(오답) - BufferedWriter이용한 방법
	//이 방법은 문제에서 원한 방식이 아니지만 그래도 처음 BufferedWriter제대로 사용해봐서 참고용으로 백업함
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	    int n = Integer.parseInt(br.readLine());
	    int[] arr = new int[n];
	    for (int i=0; i<arr.length; i++){
	      arr[i] = Integer.parseInt(br.readLine());
	    }

	    Stack<Integer> stack = new Stack<>();
	    int index = 1;
	    int i = 0;
	    int point = 0;
	    while(i < n){
	      String check = "";
	      
	      if (!stack.isEmpty() && stack.peek() > arr[i]){
	        check = "NO";
	        bw.write(check);
	        break;
	      } else if (!stack.isEmpty() && stack.peek() == arr[i]){
	        stack.pop();
	        check = "-";
	        point = Math.max(index, point);
	        i++;
	        index = !stack.isEmpty() ? stack.peek() : 0;
	      
	      } else {
	        if (!stack.isEmpty() && stack.peek() == index){
	          index = point;
	        } 
	        stack.push(index);
	        check = "+";
	        index++;
	        
	      }
	      bw.write(check);
	      bw.newLine();
	   
	      
	    }
	     bw.flush();
	      bw.close();

	  }

}
