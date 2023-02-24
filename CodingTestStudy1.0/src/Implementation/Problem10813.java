package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10813 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    StringTokenizer str = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(str.nextToken());
	    int M = Integer.parseInt(str.nextToken());
	    int[] arr = new int[N];

	    for (int i=0; i<arr.length; i++){
	      arr[i] = i+1;
	    }
	    int temp = 0;
	    for (int i=0; i<M; i++){
	      str = new StringTokenizer(br.readLine());
	      int a = Integer.parseInt(str.nextToken()) - 1;
	      int b = Integer.parseInt(str.nextToken()) - 1;
	      temp = arr[a];
	      arr[a] = arr[b];
	      arr[b] = temp;
	      
	    }

	    for (int i=0; i<arr.length; i++){
	      System.out.print(arr[i]+" ");
	      
	    }
	    }
}
