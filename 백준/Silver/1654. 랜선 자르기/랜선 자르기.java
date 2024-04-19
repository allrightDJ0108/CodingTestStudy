import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(str.nextToken());
        int N = Integer.parseInt(str.nextToken());
        
        int[] arr = new int[K];
        long max = 0;
        
        for (int i=0; i<K; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	max = Math.max(max, arr[i]);
        }
        
        long answer = 0;
        long start = 1;
        long end = max;
        
        
        while (start <= end) {
        	long cnt = 0;
        	long mid = (start + end) / 2;
            
            for (int i=0; i<K; i++) {
            	cnt += arr[i] / mid;
            }
            
        	if (cnt >= N) {
        		start = mid + 1;
        		answer = Math.max(answer, mid);
        	} else {
        		end = mid - 1;
        	}
            
        }
        
        System.out.println(answer);
        
    }
    
    
}
