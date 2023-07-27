package Samsung;

import java.io.*;
import java.util.*;

public class Problem19238 {
	
	static int N, M, S;
	static int[][] map;
	static int sx, sy;
	static int[][] info;
	static Queue<int[]> q = new LinkedList<>();
	static int[][] dir = {{0,-1}, {0,1}, {1,0}, {-1,0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		S = Integer.parseInt(str.nextToken());
		
		map = new int[N+1][N+1];
		for (int i=1; i<N+1; i++) {
			str = new StringTokenizer(br.readLine());
			int temp = 0;
			for (int j=1; j<N+1; j++) {
				temp = Integer.parseInt(str.nextToken());
				if (temp == 1) temp = 9999;
				map[i][j] = temp;
			}
		}
		
		str = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(str.nextToken());
		sy = Integer.parseInt(str.nextToken());
		
		info = new int[M+1][5];				//0번칸은 거리 계산 후 대입
		for (int i=1; i<M+1; i++) {
			str = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			int gx = Integer.parseInt(str.nextToken());
			int gy = Integer.parseInt(str.nextToken());
			map[x][y] = i;					//그래프에 위치 표시
			map[gx][gy] = i + 10000;		//M의 최대값은 N^2이므로 절대 나오지 않을 숫자를 더해 목적지 설정
			
			info[i][1] = x;
			info[i][2] = y;
			info[i][3] = gx;
			info[i][4] = gy;
			
		}
		
		
		while (S > 0) {
			int useS = 0;
			
			//가장 짧은 거리와 승객 선택
			int thisNo = 10000;
			int thisIdx = 0;
			for (int i=1; i<M+1; i++) {
				if (info[i][0] != 11111) {
					info[i][0] = distanceFunc(sx,sy,info[i][1],info[i][2]);		//거리 계산
					if (thisNo > info[i][0]) {
						thisNo = info[i][0];
						thisIdx = i;
					}
				}
			}
			
			if (thisNo == 10000 && thisIdx == 0) {
				break;
			}
			if (thisNo == -1) {
				S = -1;
				break;
			}
			
			//승객에게 이동
			S = usingfFunc(S, info[thisIdx][0], 1);
			
			//목적지까지 이동					//1,2는 출발지 3,4는 목적지
			useS = distanceFunc(info[thisIdx][1], info[thisIdx][2], info[thisIdx][3], info[thisIdx][4]);
			//이동 후 남은 연료
			S = usingfFunc(S, useS, 1);
			if (S >= 0) {	
				//이동에 성공 시 소모 연료량 두 배 충전
				S = usingfFunc(S, useS, 2);
			} else {
				//이동에 실패 시 -1 반환
				S = -1;
			}
			
			
			info[thisIdx][0] = 11111;		//이동이 완료된 경우 완료 처리
			sx = info[thisIdx][3];
			sy = info[thisIdx][4];
			
			
		}
		
		
		System.out.println(S);
		
		
		
	}
	
	//연료 계산하는 함수
	static int usingfFunc(int cur, int use, int sol) {
		if (sol == 1) {		//승객 또는 목적지로 이동하는 경우
			cur = cur - use;
		} else {			//목적지 도달에 성공한 경우
			cur = cur + (use * 2);
		}
		
		if (cur < 0) cur = -1;
		return cur;
	}
	
	//최단거리 구하는 함수
	static int distanceFunc(int x, int y, int gx, int gy) {
		q = new LinkedList<>();
		q.add(new int[]{x, y});
		
		int[][] visited = new int[N+1][N+1];
		visited[x][y] = 1;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			for (int i=0; i<4; i++) {
				int nextX = curX + dir[i][0];
				int nextY = curY + dir[i][1];
				if (nextX > 0 && nextY > 0 && nextX <= N && nextY <= N) {
					if (nextX == gx && nextY == gy) {
						return visited[curX][curY];
					}
					if (map[nextX][nextY] != 9999) {
						if (map[nextX][nextY] >= 0 && visited[nextX][nextY] == 0) {
							q.add(new int[] {nextX, nextY});
							visited[nextX][nextY] = visited[curX][curY] + 1;
						}
					}
				}
			}
		}
		
		return -1;
	}


}
