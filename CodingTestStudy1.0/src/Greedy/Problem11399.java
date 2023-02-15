package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11399 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int N = Integer.parseInt(br.readLine());
	    StringTokenizer str = new StringTokenizer(br.readLine());

	    int[] arr = new int[N];
	    for (int i=0; i<N; i++){
	      arr[i] = Integer.parseInt(str.nextToken());
	    }

	    Arrays.sort(arr);
	    int result = 0;
	    int temp = 0;
	    for (int i=0; i<N; i++){
	      temp += arr[i];
	      result += temp;
	    }

	    System.out.println(result);
	    
	    }
}
