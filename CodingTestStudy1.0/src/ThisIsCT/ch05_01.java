package ThisIsCT;

import java.io.*;

public class ch05_01 {

	//ch.05 DFS/BFS
	//음료수 얼려 먹기
	
	static int N, M;
	static int[][] arr;
	static int[][] visited;
	static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tempStr = br.readLine().split(" ");
		N = Integer.parseInt(tempStr[0]);
		M = Integer.parseInt(tempStr[1]);
		arr = new int[N][M];
		visited = new int[N][M];
		
		for (int i=0; i<N; i++) {
			tempStr = br.readLine().split("");
			for (int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(tempStr[j]);
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (arr[i][j] == 0 && visited[i][j] == 0) {
					//구멍이 뚫려있으면서 아직 방문하지 않은 구역
					cnt++;
					dfsFn(i,j);
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
	static void dfsFn(int x, int y) {
		
		for (int i=0; i<4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (arr[nx][ny] == 0 && visited[nx][ny] == 0) {
					visited[nx][ny] = cnt;
					dfsFn(nx,ny);
				}
			}
			
		}
		
	}
}
