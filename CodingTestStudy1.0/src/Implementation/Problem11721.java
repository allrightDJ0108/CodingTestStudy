package Implementation;

import java.util.Scanner;

public class Problem11721 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String A = scan.nextLine();
		scan.close();
		
		char[] ch = new char[100];
		
		for (int i=0; i < A.length(); i++) {
			ch[i] = A.charAt(i);
			System.out.print(ch[i]);
			if ((i+1) % 10 == 0 && (i+1) / 10 != 0) {
				System.out.println();
			}
		}
		
		
	}
}
