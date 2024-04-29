import java.util.*;

class Solution {
    
    public long solution(int[] sequence) {
        long answer = 0;
        
        long purse1 = 0; // [1, -1, 1, -1, ...] 패턴으로 시작
        long purse2 = 0; // [-1, 1, -1, 1, ...] 패턴으로 시작
        boolean isPlus = true; // 펄스 값이 +1 또는 -1인지 결정

        for (int num : sequence) {
            // isPlus가 true일 때, purse1은 num을 더하고, purse2는 num을 빼고
            // isPlus가 false일 때, purse1은 num을 빼고, purse2는 num을 더함
            purse1 += isPlus ? num : -num;
            purse2 += isPlus ? -num : num;

            // 각 패턴에서 최대 연속 부분 수열 합을 유지
            purse1 = Math.max(0, purse1);
            purse2 = Math.max(0, purse2);

            // 두 패턴 중 최대값을 갱신
            answer = Math.max(answer, Math.max(purse1, purse2));

            // 펄스 패턴 전환
            isPlus = !isPlus;
        }
        
        return answer;
    }
}