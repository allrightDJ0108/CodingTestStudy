package Implementation;

import java.util.Scanner;

public class Problem10809 {

public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String S = scan.nextLine();
		scan.close();
		
		int[] ch = new int[26];
		
		//2022.11.28 배열의 기본값을 -1로 초기화
		for (int i=0;i<ch.length;i++) {
			ch[i] = -1;
		}
		
		for (int i=0; i < S.length(); i++) {
			System.out.println(i);
			int cnt = 0;
			int num1 = 97;
			while(cnt < 26) {
				
				if (S.charAt(i) == num1 && ch[cnt] == -1) {
					ch[cnt] = i;
					//System.out.println(cnt +" "+i);
				} 
				
				cnt++;
				num1++;
				
			}
		}
			
			for (int i=0; i < ch.length ;i++) {
				
				//2022.11.28 특정 인덱스만 안도는 이유였음,,ㅎㅎ
				//if (ch[i]==0) ch[i] = -1;
				
				System.out.print(ch[i] + " ");
			
			}
			
			
		}
}
