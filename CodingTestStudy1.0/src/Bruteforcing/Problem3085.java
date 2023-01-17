package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3085 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		int max = 0;
		
		//보드 채우기
		for (int i=0;i<N;i++) {
			char[] arrCh = br.readLine().toCharArray();
			for (int j=0; j<N;j++) {
				arr[i][j] = arrCh[j];
			}
		}
		
		//가로 기준으로 하나하나씩 바꾸기 작업
		for (int i=0;i<N;i++) {
			for (int j=0; j<N-1;j++) {
				//인접한 칸 바꾸기
				char swap = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = swap;
				//사탕 개수
				max = Math.max(countCandy(arr, N), max);
				//배열 다시 바꾸기
				swap = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = swap;
				
			}
		}
		
		//세로 기준으로 하나하나씩 바꾸기 작업
		for (int i=0;i<N;i++) {
			for (int j=0; j<N-1;j++) {
				//인접한 칸 바꾸기
				char swap = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = swap;
				//사탕 개수
				max = Math.max(countCandy(arr, N), max);
				//배열 다시 바꾸기
				swap = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = swap;
				
			}
		}
		
		System.out.println(max);
		
	}
	
	static int countCandy(char[][] arr, int N) {
		int max = 0;
		
		//가로
		for (int i=0;i<N;i++) {
			int cnt = 1;
			for (int j=0; j<N-1;j++) {
				if (arr[i][j] == arr[i][j+1]) {
					cnt++;
					max = Math.max(max, cnt);
				} else {
					cnt = 1;
				}
				
			}
		}
		
		//세로
		for (int i=0;i<N;i++) {
			int cnt = 1;
			for (int j=0; j<N-1;j++) {
				if (arr[j][i] == arr[j+1][i]) {
					cnt++;
					max = Math.max(max, cnt);
				} else {
					cnt = 1;
				}
			}
		}
		
		return max;
	}
	
	//처음에 시도했던 새로운 방식..^^
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		
		
		int cCount = 0;
		int pCount = 0;
		int zCount = 0;
		int yCount = 0;
		
		
		//보드 채우기
		for (int i=0;i<N;i++) {
			char[] arrCh = br.readLine().toCharArray();
			for (int j=0; j<N;j++) {
				arr[i][j] = arrCh[j];
				char c = arr[i][j];
				 if(c == 'C') {
			    	cCount++;
			    } else if(c == 'P') {
			    	pCount++;
			    } else if(c == 'Z') {
			    	zCount++;
			    } else if(c == 'Y') {
			    	yCount++;
			    }
			}
		}
		
		//1. 가장 많은 색깔 찾기
		int max = cCount;
		char ch = 'C';
		if (max < pCount) {
			max = pCount;
			ch = 'P';
		} else if (max < zCount) {
			max = zCount;
			ch = 'Z';
		} else if (max < yCount) {
			max = yCount;
			ch = 'Y';
		}
		
		//System.out.println(max);
		//System.out.println(ch);
		
		
		//2. 한가지 색으로 이루어진 배열 구하기
		int[][] newArr = new int[N][N];
		
		for (int i=0;i<arr.length;i++) {
			for (int j=0; j<arr[i].length;j++) {
				char c = arr[i][j];
				 if(c == ch) {
					 newArr[i][j] = 1;
			    } 
			}
		}
		
		//3. 배열의 가로 세로를 비교해 가장 큰 수에 +1 하기
		int resMax = 0;
		int rowSum = 0;
		int colSum = 0;
		for (int i=0;i<newArr.length;i++) {
			for (int j=0; j<newArr[i].length;j++) {
				rowSum += newArr[i][j];
			}
			//System.out.println("rowSum "+rowSum);
			if (resMax < rowSum) {
				resMax = rowSum;
			}
			rowSum = 0;
		}
		for (int i=0;i<newArr.length;i++) {
			for (int j=0; j<newArr[i].length;j++) {
				colSum += newArr[j][i];
			}
			//System.out.println("colSum "+colSum);
			if (resMax < colSum) {
				resMax = colSum;
			}
			colSum = 0;
		}
		
		if (resMax >= N) {
			System.out.println(N);
		} else {
			System.out.println(resMax + 1);
		}
		
		
	}
	*/
}
