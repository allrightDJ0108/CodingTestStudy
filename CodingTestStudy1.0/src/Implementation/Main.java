package Implementation;


import java.util.Scanner;

public class Main {
public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String S = scan.nextLine();
		scan.close();
		
		int[] ch = new int[26];
		
		for (int i=0;i<ch.length;i++) {
			ch[i] = -1;
		}
		
		for (int i=0; i < S.length(); i++) {
			int cnt = 0;
			int num1 = 97;
			while(cnt < 26) {
				
				if (S.charAt(i) == num1 && ch[cnt] == -1) {
					ch[cnt] = i;
				} 
				
				cnt++;
				num1++;
				
			}
		}
			
			for (int i=0; i < ch.length ;i++) {
				
				System.out.print(ch[i] + " ");
			
			}
			
		}
	
}


