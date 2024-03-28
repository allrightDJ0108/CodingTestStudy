import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 1;
        
        // 연속되면 하나의 종류로 치고, 단 최대값은 n/2를 넘을 수 없음

        Arrays.sort(nums);
        
        int size = nums.length;
        
        for (int i=1; i<size; i++){
            if (nums[i] != nums[i-1]){
                answer++;
                if(answer > size / 2) return size / 2;
            }
        }
        
        return answer;
    }
}