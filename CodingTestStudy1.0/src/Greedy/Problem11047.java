package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11047 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    StringTokenizer str = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(str.nextToken());
	    int K = Integer.parseInt(str.nextToken());

	    int[] arr = new int[N];
	    for (int i=0; i<N; i++){
	      arr[i] = Integer.parseInt(br.readLine());
	    }

	    int result = 0;
	    int index = N-1;
	    while (index > -1){
	      int temp  = K / arr[index]; 
	      if ( temp >= 1)
	      result += temp;
	      K = K % arr[index];
	      index--;
	      
	    }

	    System.out.println(result);
	    
	    }
}
