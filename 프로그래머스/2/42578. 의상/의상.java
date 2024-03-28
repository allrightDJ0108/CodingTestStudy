import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        // 경우의 수 공식
        for (String key : map.keySet()){
            answer *= map.get(key) + 1;
        }
        
        // 아무것도 입지 않는 경우 빼기
        return answer - 1;
    }
}