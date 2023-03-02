package Implementation;

import java.io.*;
import java.util.*;

public class Problem25206 {
	//230302 넘버포맷 에러 어떻게 하지ㅠㅠ
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str;
		String subNm = "";
		double  grade = 0;
		String score = "";
		double  total = 20;
		double  sum = 0;
		String[] scoreList = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
		double[] gradeList = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};
		for (int i=0; i<20; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			
			subNm = str.nextToken();
			grade = Double.parseDouble(br.readLine());
			score = str.nextToken();
			
			for (int j=0; i<scoreList.length; j++) {
				if (score.equals(scoreList[j])) {
					sum += gradeList[j] * grade;
				}
			}
			
		}
		
		double result = sum / total;
		System.out.println(result);
	}
}
