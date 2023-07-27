package Samsung;

import java.io.*;
import java.util.*;

public class Problem19238 {
	// 다정 수정 후 완성 풀이

	static int N, M, S;
	static int[][] map;
	static int[][] info;
	static int sx, sy;
	static int cnt = 0;

	static Queue<int[]> q = new LinkedList<>();
	static int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		S = Integer.parseInt(str.nextToken());

		map = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			str = new StringTokenizer(br.readLine());
			int temp = 0;
			for (int j = 1; j < N + 1; j++) {
				temp = Integer.parseInt(str.nextToken());
				if (temp == 1)
					temp = -1;
				map[i][j] = temp;
			}
		}

		str = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(str.nextToken());
		sy = Integer.parseInt(str.nextToken());

		info = new int[M + 1][5]; // 0번칸은 거리 계산 후 대입
		for (int i = 1; i < M + 1; i++) {
			str = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			int gx = Integer.parseInt(str.nextToken());
			int gy = Integer.parseInt(str.nextToken());
			map[x][y] = i; // 그래프에 위치 표시
			//map[gx][gy] = i + 10000; // M의 최대값은 N^2이므로 절대 나오지 않을 숫자를 더해 목적지 설정

			info[i][1] = x;
			info[i][2] = y;
			info[i][3] = gx;
			info[i][4] = gy;

		}

		int result = -1;
		while (true) {

			int[] passInfo = bfsFunc(sx, sy);		//[0]이 승객 번호, [1]이 승객까지 거리

			move(passInfo);

			if (passInfo[0] == 0 || S < 0)
				break;

			cnt++;
			if (cnt == M) {
				result = S;
				break;
			}
		}

		System.out.println(result);

	}

	//승객 운반 및 오일 충전
	private static void move(int[] near) {
		// 거리 구하기
		int p = near[0];
		int dir = distanceFunc(info[p][1], info[p][2], info[p][3], info[p][4]);
		// oil 양 줄인 후 충전
		S -= dir + near[1];
		if (S < 0)
			return;
		S += (dir * 2);
		// 승객 초기화
		map[info[p][1]][info[p][2]] = 0;
		// 택시 위치 옮기기
		sx = info[p][3];
		sy = info[p][4];
	}

	// 최단거리 구하는 함수
	static int distanceFunc(int x, int y, int gx, int gy) {
		int minDir = Integer.MAX_VALUE;
		q = new LinkedList<>();
		q.add(new int[] { x, y, 0 });

		boolean[][] visited = new boolean[N+1][N+1];
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = now[0] + dir[i][0];
				int nextY = now[1] + dir[i][1];
				if(nextX >= N || nextX < 0 || nextY >= N || nextY < 0) continue;
				if(map[nextX][nextY] == -1 || visited[nextX][nextY]) continue;
				if(nextX == gx && nextY == gy) { // 도착지이면 
					if(now[2]+1 < minDir) // 최소거리 갱신 
						minDir = now[2]+1;
				} else if(!visited[nextX][nextY]) {
					q.add(new int[] {nextX, nextY, now[2]+1});
					visited[nextX][nextY] = true;
				}
			}
		}

		return minDir;
	}

	// 가장 가까운 승객 찾기
	static int[] bfsFunc(int x, int y) {
		
		//승객과 택시가 같은 위치에 있는 경우
		if (map[x][y] > 0) {
			return new int[] {map[x][y], 0};
		}
		
		int near = 0;						//가장 가까운 승객
		int minDir = Integer.MAX_VALUE;		//가장 가까운 승객과의 거리
		
		q = new LinkedList<>();
		q.add(new int[] { x, y, 0 });

		boolean[][] visited = new boolean[N+1][N+1];
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = now[0] + dir[i][0];
				int nextY = now[1] + dir[i][1];
				
				if(nextX >= N || nextX < 0 || nextY >= N || nextY < 0) continue;
				if(map[nextX][nextY] == -1 || visited[nextX][nextY]) continue;
				if(map[nextX][nextY] > 0) { // 승객이면 
					if(now[2]+1 < minDir) { // 거리가 최소면
						minDir = now[2]+1; // 거리 갱신 
						near = map[nextX][nextY]; // 내가 제일 가까운 승객 
					} else if(now[2]+1 == minDir) { // 택시로부터 최소 거리 승객과 같은 거리면 
						if(nextX < info[near][1]) { // 행이 더 작으면 
							near = map[nextX][nextY]; // 내가 제일 가까운 승객 
						} else if(nextX == info[near][1] && nextY < info[near][2]) { // 행은 같은데 열이 더 작으면  
							near = map[nextX][nextY]; // 내가 제일 가까운 승객
						}
					}
				}
				
				if(!visited[nextX][nextY]) {
					q.add(new int[] {nextX, nextY, now[2]+1});
					visited[nextX][nextY] = true;
				}
			}
		}

	return new int[]{near,minDir};
}}
