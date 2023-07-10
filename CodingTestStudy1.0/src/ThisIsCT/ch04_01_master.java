package ThisIsCT;

import java.io.*;

public class ch04_01_master {
	// Ch.04 구현
	// 예제 4-1. 상하좌우
	// 책에서 풀이한 방법

	static int N;
	static int x = 0, y = 0;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static String[] moveType = {"R","L","D","U" };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String[] plan = br.readLine().split(" ");
		
		for (String i : plan) {
			int nx = 0 ;
			int ny = 0 ;
			for (int j=0; j< moveType.length; j++) {
				if (moveType[j].equals(i)) {
					nx = x + dx[j];
					ny = y + dy[j];
				}
				
			}
			if(nx < 0|| nx >= N || ny < 0 || ny >= N) {
				continue;
			}
			x = nx; y = ny;
		}
		
		System.out.println((x+1) + " "+ (y+1));
		

	}


}
