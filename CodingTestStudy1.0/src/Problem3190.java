import java.util.HashMap;
import java.util.Scanner;

public class Problem3190 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();	//보드의 크기
		int K = scan.nextInt();	//사과의 개수
		int[][] board = new int[N][N];
		int x = 0;
		int y = 0;
		for (int i = 0; i < K; i++) {
			x = scan.nextInt();	//사과의 위치
			y = scan.nextInt();	//사과의 위치
			board[x-1][y-1] = 1;
		}
		
		int L = scan.nextInt();	//뱀의 방향 변환 횟수
		//int X = 0;
		//char C = 0 ;
		HashMap<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < L; i++) {
			map.put("X"+i, scan.nextInt());		//게임 경과시간
			map.put("C"+i, scan.next().charAt(0));	//회전 방향
			//X = scan.nextInt();		
			//C = scan.next().charAt(0);	//회전 방향
		}
		
		
		int l = 1;	//뱀의 길이
		int cnt = 1;	//시간 소요
		//board 영역 생성
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N; j++) {
				int X = (int)map.get("X"+j);
				String C = map.get("C"+j).toString();
				if (cnt == X) {
					//방향 전환이 일어남
					if ( C == "D") {
						//오른쪽으로 방향 전환 = 왼쪽 90도 회전
						board[i][j] = board[j][N-1-i];
					} else if (C == "L") {
						//왼쪽으로 방향 전환 = 오른쪽 90도 회전
						board[i][j] = board[N-1-j][i];
					} else {
						System.out.println("오류 발생");;
					}
					if (board[i][j] == 1) {
						System.out.println("사과 발견 "+i+","+j);
					}
				}
				if (i == x && j == y) {
					//사과가 있다!
					System.out.println("i>> "+i);
					System.out.println("j>> "+j);
					l += 1;
				}
				cnt += 1;
			}
			
		}
	}

}
