package Samsung;

import java.io.*;
import java.util.*;

public class Problem17822_re {
	//복습 후 소스코드 정리
	
	static int N, M, T;
	static int[][] arr;				//원판을 2차원 배열 형태로 표현
	static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		T = Integer.parseInt(str.nextToken());
		
		arr = new int[N+1][M+1];
		
		for (int i=1; i<N+1; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int j=1; j<M+1; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		while ( T-- > 0 ) {
			str = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(str.nextToken());
			int d = Integer.parseInt(str.nextToken());
			int k = Integer.parseInt(str.nextToken());
			
			rotateFunc(x,d,k);
			
			deleteFunc();
			
		}
		
		//결과 출력
		//남은 원판 내 숫자들의 합
		int result = 0;
		for (int i=1; i<N+1; i++) {
			for (int j=1; j<M+1; j++) {
				result += arr[i][j];
			}
		}
		System.out.println(result);
		
	}
	
	static void testFn() {
		for (int i=1; i<N+1; i++) {
			for (int j=1; j<M+1; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void rotateFunc(int x, int d, int k) {
		
		for (int i=1; i<N+1; i++) {
			
			//x의 배수인 행만 회전
			if (i % x != 0) {
				continue;
			}
			
			//회전을 위한 임시 배열 생성
			int[] temp = new int[M+1];
			
			//임시 배열 세팅
			for (int j=1; j<M+1; j++) {
				temp[j] = arr[i][j];
			}
			
			int ind = k;
			while(ind-- > 0) {
				
				//시계 방향
				if (d == 0) {
					for (int j=2; j<M+2; j++) {
						if (j == M+1) {
							temp[1] = arr[i][j-1];
							continue;
						}
						temp[j] = arr[i][j-1];
					}
				}
				
				//반시계 방향
				if (d == 1) {
					for (int j=1; j<M+1; j++) {
						if (j == M) {
							temp[M] = arr[i][1];
							continue;
						}
						temp[j] = arr[i][j+1];
						
					}
				}
				
				//원판에 변경된 숫자 바로 적용
				for (int j=1; j<M+1; j++) {
					arr[i][j] = temp[j];
				}
				
			}
			
		}
	}

	static void deleteFunc() {
		int[][] before = new int[N+1][M+1];
		boolean[][] checked = new boolean[N+1][M+1];
		int sum = 0;			//평균을 위한 총합
		int scnt = 0;			//평균을 위한 개수
		
		for (int i=1; i<N+1; i++) {
			for (int j=1; j<M+1; j++) {
				sum += arr[i][j];
				if (arr[i][j] != 0) scnt++;
				before[i][j] = arr[i][j];
				
				for (int k=0; k<4; k++) {
					int nx = i + dir[k][0];
					int ny = j + dir[k][1];
					
					if (nx < 1 || ny < 1 || nx > N || ny > M) {
						continue;
					}
					
					if (arr[i][j] == arr[nx][ny]) {
						checked[i][j] = true;
						checked[nx][ny] = true;
					}
				}
				
			}
			
			//양 끝 값이 같은 경우 처리
			if (arr[i][1] == arr[i][M]) {
				checked[i][1] = true;
				checked[i][M] = true;
			}
		}
		
		int cnt = 0;
		for (int i=1; i<N+1; i++) {
			for (int j=1; j<M+1; j++) {
				if (checked[i][j]) {
					arr[i][j] = 0;
				}
				if (before[i][j] != arr[i][j]) {
					cnt++;
				}
			}
		}
		
		if (cnt < 1) {
			avgFunc(sum, scnt);
		}
		
	}
	
	static void avgFunc(int sum, int scnt) {
		//int형끼리 나누면 int(정수)가 되므로 double(실수)로 형변환
		double s = (double) sum;
		double c = (double) scnt;
		double avg = s / c;
		
		for (int i=1; i<N+1; i++) {
			for (int j=1; j<M+1; j++) {
				if (arr[i][j] == 0) {
					continue;
				}
				if (arr[i][j] == avg) {
					continue;
				}
				if (arr[i][j] > avg) {
					arr[i][j] -= 1;
					continue;
				}
				if (arr[i][j] < avg) {
					arr[i][j] += 1;
					continue;
				}
			}
		}
	}
}
