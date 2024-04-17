import java.util.*;

class Solution {
    static int[][] box;
    
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        int n = score.length;
        
        Integer[] scores = new Integer[n];
        for (int i=0; i<n; i++){
            scores[i] = score[i];
        }
        Arrays.sort(scores, (o1,o2)-> o2 - o1);
        
        int idx = 0;
        int sum = 0;
        while (n >= m){
            // 상자 만들기
            int min = Integer.MAX_VALUE;
            for (int i=idx; i < idx + m; i++){
                min = Math.min(min, scores[i]);
            }
            sum += sumScore(min, m);
            
            n -= m;
            idx += m;
        }
        return sum;
    }
    
    static int sumScore(int min, int m){
        return min * m;
    }
}