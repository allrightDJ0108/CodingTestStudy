package step01;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int H, M;
		
		H = scan.nextInt();
		M = scan.nextInt();
		
		if ( (M - 45 >= 0) && (M - 45 < 60) ) {
			M -= 45; 
		} else if ( M - 45 < 0) {
			M = 60+(M - 45);
			H = (H == 0) ? 23 : (H-1);
			
		} 
		
		System.out.println( H+" "+M );
		scan.close();
	}
}
