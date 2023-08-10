package Functions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Rotation {
	// 90도 회전 함수

	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/rotationTest01.txt"));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 함수 실행 - 시계방향
		rotationFunc(0, 1);

		// 결과 확인
		testFunc();

		// 함수 실행 - 반시계방향
		rotationFunc(1, 2);

		// 결과 확인
		testFunc();
	}

	static void testFunc() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void rotationFunc(int r, int c) {
		//r은 회전 방향, c는 회전 횟수
		int[][] temp = new int[N][N];

		while (c-- > 0) {
			// 시계 방향
			if (r == 0) {
				int x = 0;
				int y = N - 1;

				for (int i = 0; i < N; i++, y--) {
					x = 0;
					for (int j = 0; j < N; j++, x++) {
						temp[x][y] = map[i][j];
					}
				}
			}
			// 반시계 방향
			if (r == 1) {
				int x = 0;
				int y = 0;

				for (int j = N - 1; j >= 0; j--, x++) {
					y = 0;
					for (int i = 0; i < N; i++, y++) {
						temp[x][y] = map[i][j];
					}
				}
			}
			
			// 방법 1. 회전을 여러번 하는 경우
			// 회전이 완료된 배열을 다시 원본 배열 값에 덮어 씌우기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[i][j];
				}
			}
		}

		// 방법 2. 회전을 한 번 하는 경우
		// 아래처럼 사용하는 경우 map과 temp가 같은 존재가 됨
		// 회전을 반복하는 경우 변경 사항 저장 불가
		// map = temp;

	}
}
