package Programmers;

import java.util.*;

class Problem12951 {
	
	public static void main(String args[]) {
        String[] testCase = {"3people unFollowed me", "for the last week", " for the last week "};
        for (String s : testCase) {
            System.out.println(solution(s));
        }
		
	}
	static public String solution(String s) {
		String answer = "";
		String[] array = s.split(" ");

		int strCnt = array.length;
		char endChar = s.charAt(s.length() - 1);

		for (String word : array) {
			for (int i = 0; i < word.length(); i++) {
				char temp = word.charAt(i);
				if (i == 0) {
					if (temp >= 97 && temp <= 122) {
						temp -= 32;
					}
					answer += temp;
				} else {
					if (temp >= 65 && temp <= 90) {
						temp += 32;
					}
					answer += temp;
				}
			}

			answer += " ";
		}

		if (endChar == ' ')
			return answer;
		else
			return answer.trim();

	}
}

/*
 * System.out.println(0-'A'); //65 System.out.println(0-'Z'); //90
 * System.out.println(0-'a'); //97 System.out.println(0-'z'); //122
 */
