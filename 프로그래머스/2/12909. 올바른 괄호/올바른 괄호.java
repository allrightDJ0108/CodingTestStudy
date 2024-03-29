import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        char[] arr = s.toCharArray();
        if (arr[0] == ')' || arr[arr.length-1] == '(') return answer;
        
        // int open = 0;
        // int close = 0;
        int count = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] == '(') count++;
            else count--;
            
            if (count < 0) return answer;
        }
        
        if (count == 0) answer = true;

        return answer;
    }
}