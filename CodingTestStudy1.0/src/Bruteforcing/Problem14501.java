package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14501 {
	//완전탐색을 풀고있었는데 DP가 나왔다,,, 마음의 준비가 안됐다,,,
	//준비가 되면 풀어야지..^^;
	//230525 다시 끄적이다가 도망감 ㅎㅎ
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);		//T
			arr[i][1] = Integer.parseInt(str[1]);		//P
				
		}
		
		int sum = 0;
		for (int i=0; i<N; i++) {
			int T = arr[i][0];
			int P = arr[i][1];
			for (int j=i; j<N; j++) {
				int Tb = arr[j][0];
			}
			
		}
		
		System.out.println(sum);
		
	}
}
