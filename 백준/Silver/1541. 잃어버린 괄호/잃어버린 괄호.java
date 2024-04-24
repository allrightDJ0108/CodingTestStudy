import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
      
      int result = Integer.MAX_VALUE;
      while (sub.hasMoreTokens()){
          String temp = sub.nextToken();
          StringTokenizer add = new StringTokenizer(temp, "+");
          
          int sum = 0;
          // 덧셈 식을 먼저 계산한다.
          while (add.hasMoreTokens()){
              sum += Integer.parseInt(add.nextToken());
          }
          
          // 첫번째 토큰이면 덧셈 결과를 넣어준다.
          if (result == Integer.MAX_VALUE){
              result = sum;
          } 
          // 뺄셈 식을 계산한다.
          else {
              result -= sum;
          }
      }
      
        System.out.println(result);
    }
    
    
}