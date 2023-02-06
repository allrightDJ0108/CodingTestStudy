package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem25305 {
	  public static void main(String[] args) throws IOException {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		    StringTokenizer str = new StringTokenizer(br.readLine());
		    int N = Integer.parseInt(str.nextToken());
		    int k = Integer.parseInt(str.nextToken());

		    str = new StringTokenizer(br.readLine());
		    int[] arr = new int[N];
		    
		    for (int i=0; i<arr.length; i++){
		      arr[i] = Integer.parseInt(str.nextToken());
		    }

		    Arrays.sort(arr);

		    System.out.println(arr[N-k]);
		   
		  }
}
