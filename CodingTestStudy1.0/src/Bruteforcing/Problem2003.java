package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2003 {
	
	//230211 미완성 : 투포인터 알고리즘으로 다시풀기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		String[] stArr = br.readLine().split(" ");
		int[] arr = new int[stArr.length];
		
		for (int i=0; i<stArr.length; i++) {
			arr[i] = Integer.parseInt(stArr[i]);
		}
		
		int cnt = 2; //몇개 조합으로 합을 구할지
		int result = 0;

		while(cnt <= N) {
			for (int i=0; i<=N-cnt; i++) {
				int sum = 0;
				if (i+cnt <= N) {
					for (int j=i; j<i+cnt; j++) {
						sum += arr[j];
					}
				}
				System.out.println(cnt);
				System.out.println(sum);
				if (sum == M) {
					result++;
				}
				System.out.println("======");
				
			}
			cnt++;
			
		}
		
		System.out.println(result);
			
	}
}
