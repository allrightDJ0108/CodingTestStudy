package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str1 = new StringTokenizer(br.readLine());
		String[] str2 = br.readLine().split(" ");
		
		int N = Integer.parseInt(str1.nextToken());
		int M = Integer.parseInt(str1.nextToken());
		
		//3중 for문 이용
		int sum = 0;
		int max = 0;
		
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N ; j++) {
				for (int k=j+1; k<N; k++) {
					sum = Integer.parseInt(str2[k]) + Integer.parseInt(str2[j]) + Integer.parseInt(str2[i]);
					if (sum <= M && max < sum) {
							max = sum;
					}
				}
			}
		}
		
		System.out.println(max);
		
		
		//처음 시도했던 방법(오답)
		/*
		Arrays.sort(str2, Collections.reverseOrder());
		
		int index=0;	//배열 인덱스
		int i=0;		//그다음 최대값
		int num = 0;	//M에서 최대값 빼고 남은 것
		int sum = 0;	//정답 후보
		int result = 0;	//정답 저장
		while (true) {
			int K = Integer.parseInt(str2[i]);
			
			if (i == 0) {
				num = M - K;
			} else {
				num = num - K;
			}
			
			if (num < 0 ) {
				i++;
			} else {
				sum += K;
				index++;
				i++;
			}
			
			if ( result < sum ) {
				result = sum;
			}
			
			if (index > 3 || i > str2.length) {
				break;
			}
			
		}
		
		
		System.out.println(result);
		*/
	}
}
