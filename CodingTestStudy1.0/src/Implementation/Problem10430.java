package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] num = new int[3];

		StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i=0;i<num.length;i++) {
        	num[i] = Integer.parseInt(str.nextToken());
        }
        
        int A = num[0];
        int B = num[1];
        int C = num[2];
        
        System.out.println((A+B)%C);
        System.out.println(((A%C) + (B%C))%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C) * (B%C))%C);
		
	}
}
