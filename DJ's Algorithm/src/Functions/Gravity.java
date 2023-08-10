package Functions;

import java.io.*;
import java.util.Scanner;

public class Gravity {
	// 2차원 배열에 중력이 작용하는 기능

	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Test파일 읽어오는 부분
		// 첫번째 줄에 배열의 크기 N (배열은 N*N)
		// 두번째 줄부터 2차원 배열 정보 (-1은 벽, -2는 빈칸 - 벽은 중력 미작용)
		System.setIn(new FileInputStream("res/gravityTest01.txt"));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 함수 실행
		gravityFunc();
		
		// 결과 확인
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// 중력 작용 함수
	static void gravityFunc() {
		for (int j = 0; j < N; j++) {			//열 고정
			for (int i = N - 2; i >= 0; i--) {	//행 이동
				//가장 아래(N-1)에서 바로 윗 칸(N-2)부터 탐색
				
				//현재 칸이 빈칸인 경우 SKIP
				if (map[i][j] == -2) {
					continue;
				}
				//현재 칸이 벽이면 SKIP
				if (map[i][j] == -1) {
					continue;
				}
				
				int tX = i + 1;		//현재 칸의 다음 칸
				while (true) {
					if (map[tX][j] == -2) {
						//다음 칸이 빈칸인 경우 행 크기 증가
						tX++;
					} else {
						//다음 칸이 빈칸이 아닐 경우 반복문 종료
						break;
					}
					if (tX == N) {
						//가장 끝 칸에 도달한 경우 반복문 종료
						break;
					}
				}
				
				//행 크기가 처음과 동일한 경우 미이동
				if (tX == i + 1) {
					continue;
				}
				
				//이동
				map[tX-1][j] = map[i][j];
				map[i][j] = -2;
			}
		}
	}
}
