package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		//정답
		int cnt = 0;
		int result = 0;
		
		for (int i=1; i<=N; i++) {
			if ( N % i == 0 ) {
				cnt++;
			} 
			if (cnt == K) {
				result = i;
				i = N;
			} 
		}
		
		System.out.println(result);
		
		
		//처음에 시도한 방법(오답)
		/*
		int cnt = 0;
		int[] arr = new int[N];
		
		for (int i=1; i<=N; i++) {
			if ( N % i == 0 ) {
				arr[i-1] = i;
				cnt++;
			} //else arr[i] = 100000;
		}
		
		if (cnt < K) {
			System.out.println(0);
		} else {
			System.out.println(arr[K-1]);
		}
		*/
	}

}
