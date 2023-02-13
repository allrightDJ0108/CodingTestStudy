package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2003 {
	
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
		
		//230213 투포인터 풀이
		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		
		while(start < N) {
			
			if (sum > M || end == N) {
				//sum이 M을 초과하거나, end가 범위를 벗어나는 경우 : start를 오른쪽으로 이동, sum에서 -
				sum -= arr[start++];
			} else {
				//end를 오른쪽으로 이동시키면서 sum 구함
				sum += arr[end++];
			}
			
			if (sum == M) cnt++;
			
		}
		
		System.out.println(cnt);
		
		//230211 미완성 풀이
		/*
		
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
		*/
			
	}
}
