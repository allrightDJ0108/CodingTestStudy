package ThisIsCT;

import java.io.*;
import java.util.Arrays;

public class ch07_03 {
	//ch.07 이진 탐색
	//떡볶이 떡 만들기
	//절단기의 높이가 큰 수이므로, 바로 이진 탐색 떠올려야 함!!(순차 탐색 이용 시 시간 초과)
	
	/*
	 * [파라메트릭 서치 Parametric Search]
	 * : 원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제에서 사용
	 * : 이진탐색을 이용해 풀이함.
	 * : 파라메트릭 서치에선 이진탐색을 재귀적으로 표현하지 않고 반복문을 이용해 구현함.
	 * 
	 * (문제풀이)
	 * 적절한 높이를 찾을 때까지 절단기의 높이 H를 반복해서 조정
	 * 현재 높이로 자르면 조건을 만족할 수 있는가에 대해 Yes/No 결정 후 탐색 범위를 좁혀서 해결
	 */
	
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" "); 
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		arr = new int[N];
		
		input = br.readLine().split(" "); 
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = arr[N-1];	//최대 길이는 가장 긴 떡
		int result = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			int total = 0;
			
			for (int i=0; i<N; i++) {
				if (arr[i] > mid) {
					total += (arr[i] - mid);
				}
			}
			
			if (total < M) {
				//떡 양이 부족한 경우 : 왼쪽 탐색 (더 많이 자르기) / 끝점을 이동
				end = mid - 1;
			} else {
				//떡 양이 충분한 경우 : 오른쪽 탐색 (더 적게 자르기) / 시작점을 이동
				start = mid + 1;
				
				//최대한 덜 잘랐을 때가 답이므로, result에 기록
				result = mid;
			}
			
		}
		
		System.out.println(result);
		
	}
	

}
