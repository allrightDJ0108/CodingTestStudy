package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] num = new int[6];
		int[] chess = {1,1,2,2,2,8};
			
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i=0;i<6;i++) {
        	num[i] = Integer.parseInt(str.nextToken());
        }
        
        for(int i=0;i<6;i++) {
        	System.out.print(chess[i] - num[i]);
        	if (i != 5) System.out.print(" ");
        }
		
	}
}
