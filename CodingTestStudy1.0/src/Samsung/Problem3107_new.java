package Samsung;

import java.io.*;

public class Problem3107_new {

	//다정 풀이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char arr[][] = new char[8][4];
		
		String ip = br.readLine();
		if (ip.contains("::")) {
			ip = ip.replace("::", ":zero:");
		}
		
		String[] arrStr = ip.split(":");
		
		int length = 8 - arrStr.length;
		
		
		
		
		for (int i=0, j=0; i<8; i++, j++) {
			if (arrStr[j].equals("zero")) {
				for (int k=i; k<i+length+1; k++) {
					arr[k] = "0000".toCharArray();
				}
				i += length ;
			} else {
				arr[i] = arrStr[j].toCharArray();
			}
		}
		
		for (int i=0; i<8; i++) {
			int tempLen = arr[i].length;
			if (tempLen != 4) {
				for (int k=0; k<4-tempLen; k++) {
					sb.append(0);
				}
				int ind = 0;
				for (int j=4-tempLen; j<4; j++, ind++) {
					sb.append(arr[i][ind]);
				}
			} else {
				sb.append(arr[i]);
			}
			
			if (i != 7) sb.append(":");
		}
		
		System.out.println(sb);
		
	}
}
