package Implementation;

import java.io.*;
import java.util.*;

public class Problem2578 {
	static int[][] arr;
	static int count = 0;
	static boolean flagR = false;
	static boolean flagL = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;

		arr = new int[5][5];
		for (int i = 0; i < 5; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		int ind = 0;
		for (int i = 0; i < 5; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int aws = Integer.parseInt(str.nextToken());
				ind++;
				for (int a = 0; a < 5; a++) {
					for (int b = 0; b < 5; b++) {
						if (arr[a][b] == aws) {
							arr[a][b] = 0;
						}
					}
				}
				
				bingoX();
				bingoY();
				bingoR();
				bingoL();

				//System.out.println(count);
				if (count >= 3) {
					System.out.println(ind);
					return;
				}
				count = 0;
			}
		}

	}

	static void bingoX() {
		
		for (int i = 0; i < 5; i++) {
			int tempX = 0;
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] == 0) {
					tempX++;
				}
			}
			//System.out.printf("tempX %d ", tempX );
			if (tempX == 5) {
				count++;
			}
		}

		
		

	}

	static void bingoY() {
		for (int i = 0; i < 5; i++) {
			int tempY = 0;
			for (int j = 0; j < 5; j++) {
				if (arr[j][i] == 0) {
					tempY++;
				}
			}
			//System.out.printf("tempY %d ", tempY );
			if (tempY == 5) {
				count++;
			}
		}

		

	}

	static void bingoR() {
		int tempR = 0;
		for (int i = 0; i < 5; i++) {
			if (arr[i][i] == 0) {
				tempR++;
			}
		}
		
		//System.out.printf("tempR %d ", tempR );
		if (tempR == 5) {
			count++;
		}

	}

	static void bingoL() {
		int tempL = 0;
		int j = 4;
		for (int i = 0; i < 5; i++, j--) {
			if (arr[i][j] == 0) {
				tempL++;
			}
		}

		//System.out.printf("tempL %d \n", tempL );
		if (tempL == 5) {
			count++;
		}

	}
}