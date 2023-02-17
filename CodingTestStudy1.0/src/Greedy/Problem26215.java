package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem26215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int maxT = 24 * 60;
		StringTokenizer str = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
			if (arr[i] > maxT) {
				System.out.println(-1);
				return;
			} 
		}
		
		Arrays.sort(arr);
		int cnt = 0;
		int end = arr.length - 1;
		
		while (arr[end] != 0 && cnt <= 1440) {
			Arrays.sort(arr);
			
				
			if (end != 0 && arr[end - 1] != 0) {
				arr[end] -= 1;
				arr[end - 1] -= 1;
				cnt++;
				Arrays.sort(arr);
			} else {
				cnt += arr[end];
				break;
			}
				
			
		}
		
		if (cnt <= 1440) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
		
	}
}
