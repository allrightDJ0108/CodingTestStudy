package Implementation;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String S = scan.nextLine();
		scan.close();
		
		int num1 = 97;
		int num2 = 0;
		
		
		int cnt = 1;
		while(cnt == 26) {
			for (int i=0; i < S.length(); i++) {
				if (S.charAt(i) == num1) {
					num2 = i;
				} else {
					num2 = -1;
				}
				num1++;
			
			}
			System.out.print(num2 + " ");
			//10809 푸는중
		}
		
	}
	
}


