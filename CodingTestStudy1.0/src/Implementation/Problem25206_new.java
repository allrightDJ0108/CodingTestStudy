package Implementation;

import java.io.*;
import java.util.*;

public class Problem25206_new {
	//다정 수정 풀이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str;
		String subNm = "";
		double  grade = 0;
		String score = "";
		double  total = 0;
		double  sum = 0;
		String[] scoreList = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
		double[] gradeList = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};
		for (int i=0; i<20; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			
			subNm = str.nextToken();
			grade = Double.parseDouble(str.nextToken());
			score = str.nextToken();
			
			for (int j=0; j<scoreList.length; j++) {
				if (score.equals(scoreList[j])) {
					sum += gradeList[j] * grade;
					if (j != scoreList.length-1) {
						total += grade;
					}
				}
			}
			
		}
		
		double result = sum / total;
		System.out.printf("%.6f\n", result);
	}
}
