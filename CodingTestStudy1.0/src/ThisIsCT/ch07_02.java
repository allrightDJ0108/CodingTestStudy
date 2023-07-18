package ThisIsCT;

import java.io.*;
import java.util.Arrays;

public class ch07_02 {
	//ch.07 이진 탐색
	//부품 찾기
	
	static int[] arrN;
	static int[] arrM;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arrN = new int[N];
		String[] input = br.readLine().split(" "); 
		for (int i=0; i<input.length; i++) {
			arrN[i] = Integer.parseInt(input[i]);
		}
		
		int M = Integer.parseInt(br.readLine());
		arrM = new int[M];
		input = br.readLine().split(" "); 
		for (int i=0; i<input.length; i++) {
			arrM[i] = Integer.parseInt(input[i]);
		}
		
		//이진탐색 이용을 위해 정렬
		Arrays.sort(arrN);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<M; i++) {
			//함수 호출
			int result = findFunc(0, N-1, arrM[i]);
			if ( result > 0 ) {
				sb.append("yes ");
			} else {
				sb.append("no ");
			}
			
		}
		System.out.println(sb);
	}
	
	static int findFunc(int start, int end, int target) {
		if (start > end) {
			return 0;
		}
		int mid = (start + end) / 2;
		
		if (target == arrN[mid]) {
			return mid;
		} else if (target < arrN[mid]) {
			return findFunc(start, mid-1, target);
		} else {
			return findFunc(mid+1, end, target);
		}
		
	}

}
