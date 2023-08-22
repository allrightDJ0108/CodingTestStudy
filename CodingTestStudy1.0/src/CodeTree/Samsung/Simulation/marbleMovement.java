package CodeTree.Samsung.Simulation;
//코드트리
//구슬의 이동
//https://www.codetree.ai/cote/13/problems/marble-movement/description

import java.io.*;
import java.util.*;

public class marbleMovement {

	static class Circle implements Comparable<Circle> {
		//Collections.sort 사용을 위해 implements Comparable<Circle> 추가
		int v, num, d;

		Circle(int v, int num, int d) {
			this.v = v;
			this.num = num;
			this.d = d;
		}

		@Override
		public int compareTo(Circle other) {
			if(v != other.v) {
				return v - other.v;
			}
	        if(num != other.num) {
	        	return num - other.num;
	        }
	        return d - other.d;
		}
	}

	static int n, m, t, k;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static ArrayList<Circle>[][] grid = new ArrayList[50][50];
	static ArrayList<Circle>[][] nextGrid = new ArrayList[50][50];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		t = Integer.parseInt(str.nextToken());
		k = Integer.parseInt(str.nextToken());

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				grid[i][j] = new ArrayList<>();
			}
		}

		for (int i = 1; i < m + 1; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			String inp = str.nextToken();
			int v = Integer.parseInt(str.nextToken());

			int d = 0;
			if (inp.equals("U")) {
				d = 0;
			}
			if (inp.equals("D")) {
				d = 1;
			}
			if (inp.equals("R")) {
				d = 2;
			}
			if (inp.equals("L")) {
				d = 3;
			}

			// 정렬 시 속도 내림차순, 번호 내림차순이 되도록
			// (-속도, -번호, 방향) 순으로 대입
			grid[r][c].add(new Circle(-v, -i, d));

		}

		while (t-- > 0) {
			// nextGrid 초기화
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					nextGrid[i][j] = new ArrayList<>();
				}
			}

			// 구슬의 이동
			movingFunc();

			// 구슬의 개수 조정
			selectCircle();

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					grid[i][j] = (ArrayList<Circle>) nextGrid[i][j].clone();
				}
			}
		}

		int cnt = 0;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				cnt += grid[i][j].size();
			}
		}

		System.out.println(cnt);

	}

	static boolean inRange(int x, int y) {
		return 1 <= x && x <= n && 1 <= y && y <= n;
	}

	static void movingFunc() {
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				for (int tm = 0; tm < grid[i][j].size(); tm++) {
					int v = grid[i][j].get(tm).v;
					int num = grid[i][j].get(tm).num;
					int d = grid[i][j].get(tm).d;

					int tv = -v;
					int cx = i;
					int cy = j;
					int nx = 1;
					int ny = 1;
					while (tv-- > 0) {
						nx = cx + dir[d][0];
						ny = cy + dir[d][1];
						if (!inRange(nx, ny)) {
							if (d == 0)
								d = 1;
							else if (d == 1)
								d = 0;
							else if (d == 2)
								d = 3;
							else if (d == 3)
								d = 2;
							nx = cx + dir[d][0];
							ny = cy + dir[d][1];
						}
						cx = nx;
						cy = ny;
					}

					nextGrid[nx][ny].add(new Circle(v, num, d));

				}
			}
		}
	}

	static void selectCircle() {
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				int size = (int) nextGrid[i][j].size();

				if (size >= k) {
					// 우선순위를 위한 정렬
					Collections.sort(nextGrid[i][j]);
					// k개만 남도록 반복
					while ((int) nextGrid[i][j].size() > k) {
						// 가장 마지막에 있는 항목을 제거
						int t = nextGrid[i][j].size() - 1;
						nextGrid[i][j].remove(nextGrid[i][j].size() - 1);
					}
				}
			}
		}
	}
}