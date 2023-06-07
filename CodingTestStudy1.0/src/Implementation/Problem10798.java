package Implementation;

import java.io.*;

public class Problem10798 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char word[][] = new char[6][16];
		for (int i=0; i<5; i++) {
			String str = br.readLine();
			for (int j=str.length(); j<15; j++) {
				str += ',';
			}
			word[i] = str.toCharArray();
		}
		
		
		for (int j=0; j< 15 ; j++) {
			for (int i=0; i<5; i++) {
				if (word[i][j] == ',') continue;
				System.out.print(word[i][j]);
			}
		}
	}

}
