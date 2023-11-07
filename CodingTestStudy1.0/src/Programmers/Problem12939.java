package Programmers;

import java.io.*;
import java.util.*;

class Solution {

    public static void main(String args[]) {
        String[] testCase = {"1 2 3 4", "-1 -2 -3 -4", "-1 -1"};
        for (String s : testCase) {
            System.out.println(solution(s));
        }
        
		
	}
    public static String solution(String s) {
        String answer = "";
        StringTokenizer str = new StringTokenizer(s);
        int cnt = str.countTokens();
        int[] arr = new int[cnt];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<cnt; i++){
            arr[i] = Integer.parseInt(str.nextToken());
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        answer = min + " "+ max;
        return answer;
    }
}