package Implementation;

import java.io.*;
import java.util.*;

public class Problem25206 {
	//다정 처음 풀이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str;
		String subNm = "";
		double  grade = 0.0;
		String score = "";
		double  total = 0.0;
		double  sum = 0.0;
		for (int i=0; i<20; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			
			subNm = str.nextToken();
			grade = Double.parseDouble(str.nextToken());
			score = str.nextToken();
			switch (score) {
			case "A+" : sum += 4.5 * grade; break;
			case "A0" : sum += 4.0 * grade; break;
			case "B+" : sum += 3.5 * grade; break;
			case "B0" : sum += 3.0 * grade; break;
			case "C+" : sum += 2.5 * grade; break;
			case "C0" : sum += 2.0 * grade; break;
			case "D+" : sum += 1.5 * grade; break;
			case "D0" : sum += 1.0 * grade; break;
			case "F" : sum += 0.0 * grade; break;
			case "P" : grade = 0; break;
			}
			total += grade;
			
		}
		double result = sum / total;
		System.out.printf("%.6f\n", result);
	}
}
