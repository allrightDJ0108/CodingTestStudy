package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9012_new {
	//처음 시도한 방식
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int T = Integer.parseInt(br.readLine());

	    for (int i=0; i<T; i++){
        String testCase = br.readLine();

        String[] arr = testCase.split("");
        int[] stack = new int[arr.length];
        int index = 0;

        String result = "NO";
        //테스트케이스 시작
        for (int j=0; j<arr.length; j++){
          if (arr[j].equals("(")){
            stack[index] = 1;
            index++;
          } else {
            if (index > 0){
              stack[index] = 0;
              index--;
            } else {
              index = -99;
              j = arr.length;
            }
            
          }
        }

        if (index == 0) result = "YES";
        System.out.println(result);
        //테스트케이스 종료
      } 
  }
}
