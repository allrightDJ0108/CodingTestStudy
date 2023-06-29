package Implementation;

import java.io.*;

public class Problem10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		//스택 미이용
		int result = 0;
		int open = 0;
		for (int i=0; i<str.length(); i++) {
			char temp = str.charAt(i);
			if (temp == '(') {
				open++;
			} else if (temp == ')') {
				open--;
				if (str.charAt(i-1) == '(') {	//레이저
					result += open;
				} else {			//막대기
					result += 1;
				}
			}
		}
		
		
		//스택 이용
		/*
		Stack<Character> st = new Stack<>();
		
		int result = 0;
		for (int i=0; i<str.length(); i++) {
			char temp = str.charAt(i);
			if (temp == '(') {
				st.add('(');
			} else if (temp == ')') {
				st.pop();
				if (str.charAt(i-1) == '(') {	//레이저
					result += st.size();
				} else {			//막대기
					result += 1;
				}
			}
		}
		*/
		
		System.out.println(result);
	}
}
