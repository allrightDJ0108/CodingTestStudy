import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        int size = s.length();
        int mid = size / 2;
        
        if (size % 2 == 0){            
            sb.append(s.charAt(mid - 1)).append(s.charAt(mid));
            answer = sb.toString();
        }
        else {
            answer = sb.append(s.charAt(mid)).toString();
        }
        
        return answer;
    }
}