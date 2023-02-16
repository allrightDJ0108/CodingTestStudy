package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine(),"-");
		
		int result = 0;
		int index = 0;
		
		while (str.hasMoreTokens()) {
			StringTokenizer add = new StringTokenizer(str.nextToken(), "+");
			
			int temp = 0;
			while(add.hasMoreTokens()) {
				temp += Integer.parseInt(add.nextToken());
			}
			
			if (index == 0) {
				result = temp;
			} else {
				result -= temp;
			}
			index++;
		}
		
		System.out.println(result);
		/*
		 * 처음 시도했던 삽질,,^^;
		char[] arr = br.readLine().toCharArray();
		
		int[] num = new int[50];
		char[] ch = new char[50];
		
		for (int i=1; i<arr.length; i++) {
			int temp = arr[i]; 					//char를 int로 변환(아스키)
			if (temp == 45 || temp == 43) {		//-: 45 //+: 43
				ch[i] = arr[i];
				System.out.println(ch[i]);
			} else if (i-1 >= 0) {
				if (arr[i-1] != 45 && arr[i-1] != 43) {
					num[i] = (arr[i-1]-'0') * 10 + (arr[i]-'0');
					System.out.println(num[i]);
				}
			}
			
		}
		
		for (int i=0; i<arr.length; i++) {
			if (ch[i] == 45) {
				
			}
		}
		*/
	}
}
