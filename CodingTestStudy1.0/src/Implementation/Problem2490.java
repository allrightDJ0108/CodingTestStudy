package Implementation;

import java.util.Scanner;

public class Problem2490 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[][] horse = new int[3][4];
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<4;j++) {
				horse[i][j] = scan.nextInt();
			}
		}
		
		
		for(int i=0;i<3;i++) {
			int cnt = 0;
			char ch = 0;
			for(int j=0;j<4;j++) {
				if (horse[i][j] == 1) {
					cnt++;
				}
			}
			
			//방법1		112ms
			switch (cnt) {
			case 4
			: ch = 'E'; break;
			case 3
			: ch = 'A'; break;
			case 2
			: ch = 'B'; break;
			case 1
			: ch = 'C'; break;
			case 0
			: ch = 'D'; break;
			}
			
			//방법2		108ms
			if (cnt == 4) {
				ch = 'E';
			} else if (cnt == 3) {
				ch = 'A';
			} else if (cnt == 2) {
				ch = 'B';
			} else if (cnt == 1) {
				ch = 'C';
			} else if (cnt == 0) {
				ch = 'D';
			}
			System.out.println(ch);
		}
		
		scan.close();
	}
}
