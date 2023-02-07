package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem25501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String[] sArr = new String[T];
		for (int i=0; i<T; i++) {
			sArr[i] = br.readLine();
		}
		
		for (int i=0; i<T; i++) {
			System.out.println(isPalindrome(sArr[i], 0));
		}
	
	}
	
	static StringBuilder recursion(String s, int l, int r, int cnt){
		cnt++;
		StringBuilder sb = new StringBuilder();
		if(l >= r) {
			sb.append(1 +" "+cnt);
			return sb;
		}
        else if(s.charAt(l) != s.charAt(r)) {
        	sb.append(0 +" "+cnt);
        	return sb;
        }
        else return recursion(s, l+1, r-1, cnt);
	}

	static StringBuilder isPalindrome(String s, int cnt){
        return recursion(s, 0, s.length()-1, cnt);
    }


}
