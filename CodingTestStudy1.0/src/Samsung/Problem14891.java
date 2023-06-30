package Samsung;

import java.io.*;
import java.util.*;

public class Problem14891 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer str;
      
      int[][] arr = new int[4][8];

      for (int i=0; i<4; i++) {
         str = new StringTokenizer(br.readLine(), "");
         for (int j=0; j<8; j++) {
            arr[i][j] = Integer.parseInt(str.nextToken());
         }
      }
      
      int K = Integer.parseInt(br.readLine());
      for (int i=0; i<K; i++) {
         str = new StringTokenizer(br.readLine(), " ");
         int num = Integer.parseInt(str.nextToken());
         int dir = Integer.parseInt(str.nextToken());
      }
   }
   
}