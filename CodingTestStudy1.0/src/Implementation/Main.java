package Implementation;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int a, b, c = N;
		
		int cnt = 1;
		
		while(true) {
			a = N / 10;		//십의자리
			b = N % 10;		//일의자리
			
			a += b;
			if (a >= 10) {
				a = a % 10;
			}
			N = b*10 + (a);
			
			if (c == N) {
				break;
			} else {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		scan.close();
	}
}
