import java.util.*;

class Solution {
    static int[][] box;
    
    public int solution(int k, int m, int[] score) {
        
        int n = score.length;
        
        Arrays.sort(score);
        
        int idx = n - 1;
        int answer = 0;
        
        while (n >= m){
            // 상자 만들기
            int min = Integer.MAX_VALUE;
            for (int i = idx; i > idx - m; i--){
                min = Math.min(min, score[i]);
            }
            answer += min * m;
            
            n -= m;
            idx -= m;
        }
        return answer;
    }
    
}