import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int pcnt = 0;
        int ycnt = 0;
        for (char c : s.toCharArray()){
            if (c == 'p' || c == 'P') pcnt++;
            else if (c == 'y' || c == 'Y') ycnt++;
        }
        
        if (pcnt != ycnt) answer = false;

        return answer;
    }
}