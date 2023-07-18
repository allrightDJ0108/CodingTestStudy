package ThisIsCT;

import java.io.*;

public class ch07_01 {
	// Ch.07 이진 탐색
	// 이진탐색은 자주 나오니까 소스코드 외워두기!!

	static int[] arr = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18 };
	static int N; // 배열 원소의 개수
	static int target; // 찾고자 하는 값(입력으로 받아야 함)

	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = arr.length;
		target = 6;
		
		//함수 호출
		int result = findTarget(0, N - 1, target);
		
		//찾고자 하는 값의 위치 반환
		if (result == -9999) {
			System.out.println("원소가 존재하지 않음");
		} else {
			System.out.println(result + 1);
		}
	}

	static int findTarget(int start, int end, int target) {
		if (start > end) {
			return -9999;
		}

		int mid = (start + end) / 2;

		if (target == arr[mid]) {
			return mid;
		} else if (target < arr[mid]) {
			//중간점의 값보다 작은 경우 왼쪽 탐색
			return findTarget(start, mid-1, target);
		} else {
			//중간점의 값보다 큰 경우 오른쪽 탐색
			return findTarget(mid+1, end, target);
		}

	}
}
