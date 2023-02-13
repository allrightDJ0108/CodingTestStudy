package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14501 {
	//완전탐색을 풀고있었는데 DP가 나왔다,,, 마음의 준비가 안됐다,,,
	//준비가 되면 풀어야지..^^;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
				
		}
		
		int sum = 0;
		for (int i=0; i<N; i++) {
			if (N - i >= arr[i][0]) {
				for (int j=i+1; j<i+arr[i][0]; j++) {
					arr[j][0] = 0;
				}
			} 
			System.out.println(arr[i][0]);
			
			if (arr[i][0] > 0) {
				sum+=arr[i][1];
			}
					
			
		}
		
		System.out.println(sum);
		
	}
}
