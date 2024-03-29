package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem9012 {
	//최종 제출 방식(stack 이용)
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int T = Integer.parseInt(br.readLine());

	    for (int i=0; i<T; i++){
        String testCase = br.readLine();

        String result = "NO";
        //테스트케이스 시작
        Stack <Integer> stack = new Stack<>();
        for (int j=0; j<testCase.length(); j++){
          if (testCase.charAt(j) == '('){
            stack.push(1);
          } else {
            if (stack.empty()){
              stack.push(1);
              //result = "NO";
              break;
            } else {
              stack.pop();
            }

          }
          
        }
        if (stack.empty()) result = "YES";
        System.out.println(result);
        //테스트케이스 종료
      } 
  }
}
