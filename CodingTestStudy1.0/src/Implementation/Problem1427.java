package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1427 {
	  public static void main(String[] args) throws IOException {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		    String[] str = br.readLine().split("");
		    int s = str.length;

		    int arr[] = new int[s];
		    for (int i=0; i<s; i++){
		      arr[i] = Integer.parseInt(str[i]);
		      
		    }
		    
		    Arrays.sort(arr);
		    StringBuilder sb = new StringBuilder();
		    for (int i=s; i>0; i--){
		      sb.append(arr[i-1]);
		    }
		    System.out.println(sb);
		   
		  }
}
