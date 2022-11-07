import java.util.HashMap;
import java.util.Scanner;

public class Problem14502 {
	
	static int N, M;
	static int k = 3;	//벽의 개수
	static String [][] map;
	static HashMap<Integer, String> board = new HashMap<Integer, String>();
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		scan.nextLine();	//찌꺼기 데이터 지우기
		
		for (int i = 0; i < N ; i++) {
			board.put(i, scan.nextLine());
		}
		
		for (int i = 0; i < board.size() ; i++) {
			board.put(i, scan.nextLine());
		}
		
		
		
		System.out.println();	//얻을 수 있는 안전 영역의 최대크기
		scan.close();
		
	}

}
