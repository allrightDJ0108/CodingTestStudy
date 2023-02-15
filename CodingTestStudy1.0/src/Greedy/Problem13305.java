package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13305 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int N = Integer.parseInt(br.readLine());

	    long[] len = new long[N-1];
	    long[] cost = new long[N];

	    StringTokenizer str = new StringTokenizer(br.readLine());
	    for (int i=0; i<N-1; i++){
	      len[i] = Long.parseLong(str.nextToken());
	    }
	    
	    str = new StringTokenizer(br.readLine());
	    for (int i=0; i<N; i++){
	      cost[i] = Long.parseLong(str.nextToken());
	    }

	    long min = cost[0];
	    for (int i=1; i<cost.length-1; i++){
	      if (cost[i] > min){
	        cost[i] = min;
	      } else {
	        min = cost[i];
	      }
	    }

	    long result = 0;
	    for (int i=0; i<N-1; i++){
	      result += cost[i]*len[i];
	      //System.out.println(result);
	    }
	    
	    System.out.println(result);
	    
	    }
}
