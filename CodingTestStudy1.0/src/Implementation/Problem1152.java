package Implementation;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem1152 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		/*[방법1] - trim, split 이용*/
		String str1 = scan.nextLine().trim();	//앞, 뒤 공백 제거
		scan.close();
		
		//배열 확인
		/*
		String[] strArr = str.split(" ");	
		for (int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
		*/
		
		
		//trim()은 ""으로 만들어줄뿐, null 로 만드는 것이 아님
		if(str1.isEmpty() == false) {
			System.out.println(str1.split(" ").length);	//배열 선언 없이 바로 출력도 가능
			
		} else System.out.println(0);
		
		
		
		/*[방법2] - StringTokenizer 이용*/
		String str2 = scan.nextLine();
		StringTokenizer st = new StringTokenizer(str2, " ");
		System.out.println(st.countTokens());
		
	}
}
