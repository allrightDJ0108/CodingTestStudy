package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2750 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//1. 초간단 방법
		Arrays.sort(arr);
		
		//2. 선택정렬
		/*
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		*/
		
		//출력 시 stringBuilder를 이용한 효율 높이기!!
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			//sb.append(arr[i]);
			//sb.append("\n");
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
		
		/*
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		*/
	}
}
