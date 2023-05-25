package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem1012_230525 {
	
	static int M,N,K;
	static int[][] ground;
	static int[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	static int[] graX = {1, -1, 0, 0};
	static int[] graY = {0, 0, 1, -1};
	static int res = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int tc = 0;
		while(tc++ < T) {
			res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			ground = new int[M+1][N+1];
			visited = new int[M+1][N+1];
			
			int i=0;
			while (i++ < K) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				ground[x][y] = 1;
			}
			
			for (int x=0; x<M; x++) {
				for (int y=0; y<N; y++) {
					if (ground[x][y] != 0 && visited[x][y] == 0) {
						bfsFn(x,y);
						res++;
					}
				}
			}
			System.out.println(res);
		}
		
		
		
	}
	
	static void bfsFn(int x, int y) {
		visited[x][y] = 1;
		q.add(new int[] {x,y});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i=0; i<4; i++) {
				//방향
				int newX = cur[0] + graX[i];
				int newY = cur[1] + graY[i];
				
				//상하좌우가 그래프 범위 내인지 확인
				if (newX >= 0 && newX < M && newY >=0 && newY < N) {
					//땅이 1이면서 아직 방문하지 않은 경우
					if (ground[newX][newY] == 1 && visited[newX][newY] == 0) {
						q.add(new int[] {newX, newY});
						visited[newX][newY] = 1;
					}
					
				}
				
			}
		}
		
	}
}
