import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      
      PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
      
      int N = Integer.parseInt(br.readLine());
      
      while (N-- > 0){
          int inp = Integer.parseInt(br.readLine());
          
          if (inp == 0) {
              if (q.isEmpty()) sb.append("0").append("\n");
              else sb.append(q.poll()).append("\n");
              
          } else if (inp > 0){
              q.add(inp);
          }
          
      }
      
      System.out.println(sb);
    }
}