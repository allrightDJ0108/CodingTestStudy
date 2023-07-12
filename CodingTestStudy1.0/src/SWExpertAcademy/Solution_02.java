package SWExpertAcademy;

import java.util.*;
import java.io.*;

class Solution_02 {
	
	static int N, M, Q;
	static int[][] arr;
	static int result = 0;
	static int tempRes = 0;
	static int[][] tempArr;
	
	public static void main(String args[]) throws Exception {
		
		System.setIn(new FileInputStream("res/input02.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			result = 0;
			tempRes = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			Q = sc.nextInt();
			arr = new int[N+1][M+1];
			tempArr = new int[N+1][M+1];
			
			for (int i=1; i<N+1; i++) {
				for (int j=1; j<M+1; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i=0; i<Q; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int value = sc.nextInt();
				arr[x][y] = value;
				//새로 들어온 값이 기존에 저장된 최대값보다 큰 경우에만 func() 실행
				if (tempArr[x][y] < value) {
					tempRes = 0;
					func();
				} else {
					result += tempRes;
				}
			}

			System.out.println("#"+test_case+" "+result);
		}
	}
	
	static void func() {
		int tempX = 0;
		int tempY = 0;
		for (int i=1; i<N+1; i++) {
			int tempMax = 0;
			
			//행에서 가장 큰 값 찾기
			for (int j=1; j<M+1; j++) {
				if (tempMax < arr[i][j]) {
					tempMax = arr[i][j];
					tempX = i;
					tempY = j;
				}
			}
			
			boolean flag = true;
			//열에서 가장 큰 값 맞는지 확인
			for (int j=1; j<N+1; j++) {
				if (tempMax < arr[j][tempY]) {
					flag = false;
					j = N+2;	//false 나오면 바로 반복문 탈출
				}
			}
			if (flag) {
				tempRes++;
				result++;
				tempArr[tempX][tempY] = tempMax;
			}
		}
		
		
	}
}
