package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2562 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 9;
		int max = 0;
        int index = 0;
        int[] num = new int[N];
		
        for(int i=0;i<N;i++) {
        	num[i] = Integer.parseInt(br.readLine());
        	if (max < num[i]) {
        		max = num[i];
        		index = i + 1;
        	}
        }
        
        System.out.println(max);
        System.out.println(index);
	}
}
