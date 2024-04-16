import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (String key : keymap){
            for (int i=0; i<key.length(); i++){
                char k = key.charAt(i);
                map.put(k, Math.min(i+1, map.getOrDefault(k, Integer.MAX_VALUE)));
            }
        }
        
        
        for (int i=0; i<targets.length; i++){
            String target = targets[i];
            
            for (int j=0; j<target.length(); j++){
                char c = target.charAt(j);
                
                if (map.containsKey(c)){
                    answer[i] += map.get(c);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
    
}