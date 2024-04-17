import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(str.nextToken());
        }
        
        int[] dp = new int[N];
        
        dp[0] = arr[0];
        int max = Integer.MIN_VALUE;
        
        for (int i=0; i<N; i++) {
        	dp[i] = arr[i];
        	
        	// 이전 수열에서 현재 수보다 작은 수 탐색
        	for (int j=0; j<i; j++) {
        		if (arr[i] > arr[j]) {
        			// 기존에 있던 누적합과 새로운 누적합 중에 더 큰 합을 저장
        			dp[i] = Math.max(dp[i], dp[j] + arr[i] );
        		}
        	}
        	max = Math.max(max, dp[i]);
        	
        }
        
        System.out.println(max);
    }
    
}
