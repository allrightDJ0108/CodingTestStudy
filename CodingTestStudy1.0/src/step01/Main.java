package step01;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
		
		int x, y, N;
		
		x = scan.nextInt();
		y = scan.nextInt();
		
		if (x > 0) {
			N = (y > 0) ? 1 :  4;
		} else {
			N = (y > 0) ? 2 :  3;
		}
		

		/*
		if (x > 0) {
			if (y > 0) {
				N = 1;
			} else {
				N = 4;
			}
		} else {
			if (y>0) {
				N = 2;
			} else {
				N = 3;
			}
		}
		*/
		System.out.println(N);
		scan.close();

	}
}
