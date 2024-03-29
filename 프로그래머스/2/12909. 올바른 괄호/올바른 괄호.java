import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        char[] arr = s.toCharArray();
        if (arr[0] == ')' || arr[arr.length-1] == '(') return answer;
        
        int open = 0;
        int close = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] == '(') open++;
            else close++;
            
            if (open < close) return answer;
        }
        
        if (open == close) answer = true;

        return answer;
    }
}