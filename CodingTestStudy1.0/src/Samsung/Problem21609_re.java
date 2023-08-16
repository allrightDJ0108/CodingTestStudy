package Samsung;

import java.io.*;
import java.util.*;

public class Problem21609_re {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static Queue<int[]> q = new LinkedList<>();
	static int score = 0;

	static class Block {
		int x, y, size, rc;

		Block(int x, int y, int size, int rc) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.rc = rc;
		}
		
		public boolean compareBlock(Block other) {
			//other가 MaxBlock이면 true
			if (this.size != other.size) {
				return this.size < other.size;
			}
			
			if (this.rc != other.rc) {
				return this.rc < other.rc;
			}
			
			if (this.x != other.x) {
				return this.x < other.x;
			}
			
			return this.y < other.y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		while (true) {
			Block block = findMaxBlock();

			if (block == null) {
				break;
			}
			
			score += block.size * block.size;
			
			removeFunc(block);
			
			gravityFunc();
			
			rotateFunc();
			
			gravityFunc();
		}
		
		System.out.println(score);

	}

	static Block findMaxBlock() {

		Block maxBlock = new Block(0, 0, 0, 0);
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 검은색 블록인 경우
				if (map[i][j] == -1) {
					continue;
				}
				// 빈칸인 경우
				if (map[i][j] == -2) {
					continue;
				}
				// 무지개 블록인 경우
				if (map[i][j] == 0) {
					continue;
				}
				// 이미 방문한 경우
				if (visited[i][j]) {
					continue;
				}
				
				clearFunc();
				Block tempBlock = bfsFunc(i, j);
				
				if (maxBlock.compareBlock(tempBlock)) {
					maxBlock = tempBlock;
				}
			}
		}

		if (maxBlock.size < 2) {
			return null;
		}
		return maxBlock;

	}
	
	static void clearFunc() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] == 0) {
					visited[i][j] = false;
				}
			}
		}
	}


	static Block bfsFunc(int x, int y) {
		q.add(new int[] {x,y});
		visited[x][y] = true;
		int size = 1;
		int rc = 0;
		int color = map[x][y];
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i=0; i<4; i++) {
				int nx = cx + dir[i][0];
				int ny = cy + dir[i][1];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				
				if (visited[nx][ny]) {
					continue;
				}
				
				if (map[nx][ny] == -1) {
					continue;
				}
				
				if (map[nx][ny] == -2) {
					continue;
				}
				
				if (map[nx][ny] != color) {
					if (map[nx][ny] == 0) {
						q.add(new int[] {nx, ny});
						visited[nx][ny] = true;
						size++;
						rc++;
					}
					continue;
				}
				
				//동일한 색상의 블럭인 경우
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
				size++;
				
			}
		}

		return new Block(x, y, size, rc);
	}

	static void removeFunc(Block block) {
		int x = block.x;
		int y = block.y;
		int color = map[x][y];
		
		visited = new boolean[N][N];
		q.add(new int[] {x, y});
		visited[x][y] = true;
		map[x][y] = -2;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i=0; i<4; i++) {
				int nx = cx + dir[i][0];
				int ny = cy + dir[i][1];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				
				if (visited[nx][ny]) {
					continue;
				}
				
				if (map[nx][ny] == -1) {
					continue;
				}
				
				if (map[nx][ny] == -2) {
					continue;
				}
				
				if (map[nx][ny] != color) {
					if (map[nx][ny] == 0) {
						q.add(new int[] {nx, ny});
						visited[nx][ny] = true;
						map[nx][ny] = -2;
					}
					continue;
				}
				
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
				map[nx][ny] = -2;
			}
		}

	}

	static void gravityFunc() {
		for (int j = 0; j < N; j++) {
			for (int i = N - 2; i >= 0; i--) {
				if (map[i][j] == -1) {
					continue;
				}
				if (map[i][j] == -2) {
					continue;
				}
				
				int temp = i + 1;
				while (true) {
					if (temp > N-1) {
						break;
					}
					
					if (map[temp][j] == -2) {
						temp++;
					} else {
						break;
					}
				}
				
				if (temp == i + 1) {
					continue;
				}
				
				map[temp-1][j] = map[i][j];
				map[i][j] = -2;
			}
		}
	}

	static void rotateFunc() {
		int[][] temp = new int[N][N];
		
		int x = 0;
		int y = N - 1;
		
		for (int i=0; i<N; i++, y--) {
			x = 0;
			for (int j=0; j<N; j++, x++){
				temp[i][j] = map[x][y];
			}
		}
		
		map = temp;
	}

}
