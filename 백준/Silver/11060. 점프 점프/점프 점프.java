import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(str.nextToken());
        
        int[] inp = new int[N+1];
        int[] dp = new int[N+1];
        
        str = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<N+1; i++) {
        	inp[i] = Integer.parseInt(str.nextToken());
        	dp[i] = Integer.MAX_VALUE;
        }
        
        dp[1] = 0;
        
        for (int i = 1; i < N+1; i++) {
        	if (dp[i] == Integer.MAX_VALUE) continue; 
        	for (int j = i + 1; j <= i + inp[i] && j < N+1; j++) {
        		dp[j] = Math.min(dp[j], dp[i] + 1);
        	}
        	//func(dp);
        }
        
        int result = dp[N];
        if (result == Integer.MAX_VALUE) result = -1;
        
        System.out.println(result);
    }
    
    static void func(int[] dp) {
    	for (int i=0; i<N; i++) {
    		System.out.print(dp[i]+" ");
    	}
    	System.out.println();
    }
}
