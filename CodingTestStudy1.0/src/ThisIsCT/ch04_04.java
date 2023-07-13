package ThisIsCT;

import java.io.*;
import java.util.*;

public class ch04_04 {
	// Ch.04 구현
	// 게임 개발
	// 백준 - 14503. 로봇청소기와 유사한 문제
	
	static int N, M;
	static int[][] map;
	static int x,y,d;
	//북(0) 동(1) 남(2) 서(3)
	//서(좌) 북(상) 동(우) 남(하)
	static int[][] move = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	static int cnt = 0;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		map = new int[N+1][M+1];
		
		str = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(str.nextToken());
		y = Integer.parseInt(str.nextToken());
		d = Integer.parseInt(str.nextToken());
		
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		map[x][y] = 99;
		cnt++;
		movingFunc(d, 0);
		System.out.println(cnt);
	}
	
	static void movingFunc(int D, int tempCnt) {
		int tempX = x + move[D][0];
		int tempY = y + move[D][1];
		
		if (map[tempX][tempY] != 1 && map[tempX][tempY] == 0) {
			// 바다가 아니면서 아직 방문하지 않은 육지인 경우
			map[tempX][tempY] = 99;	//방문하면 99로 채움
			x = tempX;
			y = tempY;
			cnt++;
			tempCnt = 0;
		} else {
			// 방문할 곳이 없는 경우
			tempCnt++;
			//왼쪽으로 회전 시 D가 점차 작아짐 : 0 > 3 > 2 > 1 > 0 ...
			D--;
			if (D < 0) D = 3;
		}
			
		if (tempCnt == 4) {
			//네 방향 모두 방문할 수 없는 경우 뒤로 이동
			tempX = x - move[D][0];
			tempY = y - move[D][1];
			tempCnt = 0;
			if (map[tempX][tempY] != 1 && map[tempX][tempY] == 0) {
				x = tempX;
				y = tempY;
				
			} else {
				return;
			}
		}
			
		movingFunc(D, tempCnt);
		
	}

}
