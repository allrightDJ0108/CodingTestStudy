import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        Integer num = 0;
        for (int i=0; i<participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        for (int i=0; i<completion.length; i++){
            map.put(completion[i], map.get(completion[i]) - 1);
        }
        
        // for (Map.Entry<String, Integer> result : map.entrySet()){
        //     //System.out.println(result.getKey());
        //     //System.out.println(result.getValue());
        //     if (result.getValue() == 1) answer = result.getKey();
        // }
        
        for (String key : map.keySet()){
            //System.out.println(map.get(key));
            if (map.get(key) == 1) answer = key;
        }
        return answer;
    }
}