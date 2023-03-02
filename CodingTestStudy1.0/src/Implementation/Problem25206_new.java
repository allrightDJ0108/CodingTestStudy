package Implementation;

import java.io.*;
import java.util.*;

public class Problem25206_new {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str;
		String subNm = "";
		double  grade = 0;
		String score = "";
		double  total = 20;
		double  sum = 0;
		for (int i=0; i<20; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			
			subNm = str.nextToken();
			grade = Double.parseDouble(br.readLine());
			score = str.nextToken();
			switch (score) {
			case "A+" : sum += 4.5 * grade;
			case "A0" : sum += 4.0 * grade;
			case "B+" : sum += 3.5 * grade;
			case "B0" : sum += 3.0 * grade;
			case "C+" : sum += 2.5 * grade;
			case "C0" : sum += 2.0 * grade;
			case "D+" : sum += 1.5 * grade;
			case "D0" : sum += 1.0 * grade;
			case "F" : sum += 0.0 * grade;
			case "P" : total--;
			}
			
		}
		
		double result = sum / total;
		System.out.println(result);
	}
}
