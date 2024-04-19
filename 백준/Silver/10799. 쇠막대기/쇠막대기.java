import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
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
		
		System.out.println(result);
	}

}