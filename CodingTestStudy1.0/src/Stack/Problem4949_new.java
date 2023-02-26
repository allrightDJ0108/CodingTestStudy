package Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem4949_new {
	//참고한 방식(성능 개선)
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> st =new Stack<>();
		while(true) {
			st.clear();
			char [] nm = bf.readLine().toCharArray();
			String check = "yes";
			if(nm.length==1)break;
			for(int i=0;i<nm.length;i++) {
				if(nm[i]=='(') {
					st.push(nm[i]);
				}
				else if(nm[i]==')') {
					if(!st.isEmpty()&&st.peek()=='(') {
						st.pop();
					}
					else {
						check = "no";
						break;						
					}
				}
				else if(nm[i]=='[') {
					st.push(nm[i]);
				}
				else if(nm[i]==']') {
					if(!st.isEmpty()&&st.peek()=='[') {
						st.pop();
					}
					else {
						check = "no";
						break;						
					}
				}
				else if(nm[i]=='.') {
					if(!st.isEmpty()) {
						check = "no";
						break;
					}
				}
			}
			bw.write(check);
			bw.newLine();
		}				
		bw.flush();
		bw.close();

	}
}
