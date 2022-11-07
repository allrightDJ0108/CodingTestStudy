import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Problem3190 {
	
	static int N, K, L;
	static int[][] board;
	static List<int[]> snake = new ArrayList<>();	//참고한 부분
	static HashMap<Integer, String> map = new HashMap<Integer, String>();
	static int[] dx = { 0, 1, 0, -1 };				//참고한 부분
	static int[] dy = { 1, 0, -1, 0 }; 				//참고한 부분
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();	//보드의 크기
		K = scan.nextInt();	//사과의 개수
		board = new int[N][N];
		int x = 0;
		int y = 0;
		for (int i = 0; i < K; i++) {
			x = scan.nextInt();	//사과의 위치
			y = scan.nextInt();	//사과의 위치
			board[x-1][y-1] = 1;
		}
		
		L = scan.nextInt();	//뱀의 방향 변환 횟수
		for (int i = 0; i < L; i++) {
			map.put(scan.nextInt(), scan.next());		//게임 경과시간, 회전 방향
		}
		
		solve();
		
		
	}
	
	public static void solve() {
		int cnt = 0;		//소요 시간
		int i = 0, j = 0;	
		int d = 0;			//참고한 부분 (방향 전환)
		snake.add(new int[] { 0, 0 });	//뱀의 출발 지점
		
		while (true) {
			//증가조건
			cnt ++;
			
			//뱀 이동
			i += dx[d];
			j += dy[d];
			
			//종료조건
			if (isFinish(i, j))
				break;

			
			//사과가 있을 때
			if (board[i][j] == 1) {
				board[i][j] = 0; 	//사과 비우기
				snake.add(new int[] { i, j });	//뱀 이동, 뱀 길이 늘리기
				
			} else {
				snake.add(new int[] { i, j });	//뱀 이동
				snake.remove(0);				//뱀 꼬리 자르기
			}
			
			//설정 시간이 지난 후 방향 바꿔주기
			if (map.containsKey(cnt)) {
				if (map.get(cnt).equals("D")) {
					//오른쪽으로 회전
					d += 1;
					if (d == 4) d = 0;
				} else {
					//왼쪽으로 회전
					d -= 1;
					if (d == -1) d = 3;
					
				}
			}
			
			
		}
		
		//종료 시간 반환하기
		System.out.println(cnt);
	}
	
	public static boolean isFinish(int i, int j) {
		//종료조건1 : 벽과 부딪힘
		if (i < 0 || j < 0 || i >= N || j >= N) {
			return true;
		}
		
		//종료조건2 : 자기자신과 부딪힘
		for (int k = 0; k < snake.size(); k++) {
			int t[] = snake.get(k);
			if (i == t[0] && j == t[1]) {
				return true;
			}
		}
		
		return false;
	}

}
