package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem14503_re {
	//230912 다시 푸는중
	
	static int N, M;
	static int[][] map;
	static int r,c,d;
	
	static Queue<int[]> q = new LinkedList<>();
	static boolean[][] visited;
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};	//상우하좌

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		str = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(str.nextToken());
		c = Integer.parseInt(str.nextToken());
		d = Integer.parseInt(str.nextToken());
		
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		System.out.println(cleanFn(r,c,d));
		
	}
	
	static int cleanFn(int x, int y, int d) {
		q.add(new int[] {x,y});
		map[x][y] = 2;
		visited[x][y] = true;
		int result = 0;
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			int cd = d;
			
			int cnt = 0;
			while(cnt++ < 4) {
			
				if (cnt == 4) {
					if (cd == 0) {		
						cd = 2;
					} else if (cd == 1) {	
						cd = 3;
					} else if (cd == 2) {	
						cd = 0;
					} else if (cd == 3) {	
						cd = 1;
					}
				} else {
					if (cd == 0) {		//상 > 좌
						cd = 3;
					} else if (cd == 1) {	//우 > 상
						cd = 0;
					} else if (cd == 2) {	//하 > 우
						cd = 1;
					} else if (cd == 3) {	//좌 > 하
						cd = 2;
					}
				}
				
				
				int nx = cx + dir[cd][0];
				int ny = cy + dir[cd][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				if (visited[nx][ny]) {
					continue;
				}
				
				if (map[nx][ny] == 1) {
					continue;
				}
				
				if (map[nx][ny] == 2) {
					continue;
				}
				
				map[nx][ny] = 2;
				visited[nx][ny] = true;
				q.add(new int[] {nx, ny});
				result++;
				break;
				
				
			}
		}
		
		return result;
	}
	


}
