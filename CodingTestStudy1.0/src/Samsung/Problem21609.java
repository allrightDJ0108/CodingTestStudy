package Samsung;

import java.io.*;
import java.util.*;

public class Problem21609 {

	static int N, M;
	static int[][] map;
	static boolean[][] vis;
	static int score = 0;

	static Queue<int[]> q = new LinkedList<>();
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		while (true) {

			// 가장 큰 블록 그룹 찾기
			Block resBlock = findBlockFunc();

			// 더이상 블록 그룹이 존재하지 않으면 종료
			if (resBlock == null) {
				break;
			}

			// 점수 계산
			score += resBlock.sum * resBlock.sum;

			// 블록 그룹 제거
			removeFunc(resBlock);

			// 중력 작용
			gravityFunc();

			// 회전
			rotateFunc();

			// 중력 작용
			gravityFunc();

		}

		System.out.println(score);

	}

	// 크기가 가장 큰 블록 그룹 찾는 함수
	static Block findBlockFunc() {
		vis = new boolean[N][N];
		Block maxBlock = new Block(0, 0, 0, Integer.MIN_VALUE, Integer.MIN_VALUE);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				// 검정 블록이면 SKIP
				if (map[i][j] == -1) {
					continue;
				}

				// 빈칸이면 SKIP
				if (map[i][j] == -2) {
					continue;
				}

				// 무지개 블록이면 SKIP
				if (map[i][j] == 0) {
					continue;
				}
				if (vis[i][j]) {
					continue;
				}

				// 블록 그룹 탐색 전에 무지개 블록 방문 처리 초기화
				initRainbowFunc();

				// 블록 그룹 탐색 BFS
				// color의 번호, 기준 색상의 위치 (i,j)를 들고 이동
				Block cur = bfsFunc(i, j, map[i][j]);

				// 블록 그룹의 크기가 2보다 작으면 SKIP
				if (cur == null) {
					continue;
				}

				// 가장 큰 블록 그룹 찾기
				if (maxBlock.compareBlock(cur)) {
					maxBlock = cur;
				}
			}
		}

		// 블록 그룹을 찾지 못한 경우 NULL 리턴
		if (maxBlock.color == 0) {
			return null;
		}

		return maxBlock;

	}

	// 무지개 블록 방문 처리 초기화 함수
	static void initRainbowFunc() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					vis[i][j] = false;
				}
			}
		}
	}

	static Block bfsFunc(int x, int y, int color) {
		q.add(new int[] { x, y });
		vis[x][y] = true;
		int sum = 1; // 블록 그룹의 크기
		int rs = 0; // 블록 그룹에 포함된 무지개 블록의 개수

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dir[i][0];
				int ny = cy + dir[i][1];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (map[nx][ny] == -1) {
					continue;
				}

				if (map[nx][ny] == -2) {
					continue;
				}

				if (vis[nx][ny]) {
					continue;
				}

				// color가 다를 때 무지개 블록이면 블록 그룹에 추가
				if (map[nx][ny] != color) {
					if (map[nx][ny] == 0) {
						rs++;
						sum++;
						vis[nx][ny] = true;
						q.add(new int[] { nx, ny });
					}
					continue;
				}

				// 위 조건에 모두 포함되지 않으면
				sum++;
				vis[nx][ny] = true;
				q.add(new int[] { nx, ny });

			}

		}

		if (sum < 2) {
			return null;
		} else {
			return new Block(x, y, color, sum, rs);
		}

	}

	// 블록 그룹을 제거하는 함수
	static void removeFunc(Block block) {
		vis = new boolean[N][N];
		vis[block.x][block.y] = true;
		map[block.x][block.y] = -2;
		q.add(new int[] { block.x, block.y });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dir[i][0];
				int ny = cy + dir[i][1];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (map[nx][ny] == -1) {
					continue;
				}

				if (map[nx][ny] == -2) {
					continue;
				}

				if (vis[nx][ny]) {
					continue;
				}

				// color가 다른 것 중에 무지개인 경우 제거
				if (map[nx][ny] != block.color) {
					if (map[nx][ny] == 0) {
						q.add(new int[] { nx, ny });
						vis[nx][ny] = true;
						map[nx][ny] = -2;
					}
					continue;
				}

				// 위 조건에 모두 포함되지 않으면
				// 블록그룹 제거 (-2)
				q.add(new int[] { nx, ny });
				vis[nx][ny] = true;
				map[nx][ny] = -2;
			}
		}
	}

	// 중력 작용 함수
	static void gravityFunc() {
		for (int j = 0; j < N; j++) {			//열 고정
			for (int i = N - 2; i >= 0; i--) {	//행 이동
				//현재 칸이 빈칸인 경우 SKIP
				if (map[i][j] == -2) {
					continue;
				}
				//현재 칸이 검정 블록이면 SKIP
				if (map[i][j] == -1) {
					continue;
				}
				
				int temp = i + 1;	//현재 칸의 다음 칸
				while(true) {
					
					if (map[temp][j] == -2) { //다음 칸이 빈칸인 경우 행 크기 증가
						temp++;
					} else {	//다음 칸이 빈칸이 아닐 경우 반복문 종료
						break;
					}
					
					if (temp == N) { //가장 끝 칸에 도달한 경우 반복문 종료
						break;
					}
					
				}
				
				if (temp == i + 1) {
					//행 크기가 처음과 동일한 경우 미이동
					continue;
				}
				
				//이동
				map[temp-1][j] = map[i][j];//인덱스 맞추기 위해 -1
				map[i][j] = -2;
			}
		}
	}

	// 90도 회전 함수
	static void rotateFunc() {
		int[][] temp = new int[N][N];

		int x = 0;
		int y = 0;
		for (int j = N - 1; j >= 0; j--, x++) {
			y = 0;
			for (int i = 0; i < N; i++, y++) {
				temp[x][y] = map[i][j];
			}
		}

		map = temp;
	}

	static class Block {
		int x, y, color, sum, rs;

		public Block(int x, int y, int color, int sum, int rs) {
			this.x = x;
			this.y = y;
			this.color = color;
			this.sum = sum;
			this.rs = rs;
		}

		// 블록 그룹 비교 함수
		public boolean compareBlock(Block other) {
			// other가 더 크면 TRUE

			if (this.sum != other.sum) {
				return this.sum < other.sum;
			}

			if (this.rs != other.rs) {
				return this.rs < other.rs;
			}

			if (this.x != other.x) {
				return this.x < other.x;
			}

			return this.y < other.y;
		}
	}
}
