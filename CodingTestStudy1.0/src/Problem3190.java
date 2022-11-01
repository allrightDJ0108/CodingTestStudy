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
		int X = 0;
		char C = 0 ;
		for (int i = 0; i < L; i++) {
			X = scan.nextInt();		//게임 경과시간
			C = scan.next().charAt(0);	//회전 방향
		}
		
		
		int l = 1;	//뱀의 길이
		int cnt = 1;	//시간 소요
		int[][] lotate = new int[y][x];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N; j++) {
				if (cnt == X) {
					//방향 전환이 일어남
					if (C == 'D') {
						lotate[i][j] = board[N-1-j][i];
					} else if (C == 'L') {
						
					} else {
						System.out.println("오류 발생");;
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
