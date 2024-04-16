import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] record) {
        
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();
        
        for (String r : record){
            StringTokenizer str = new StringTokenizer(r, " ");
            
            String func = str.nextToken();
            String user = str.nextToken();
            
            if (func.equals("Enter")){
                answer.add(user+"님이 들어왔습니다.");
                
                String nickname = str.nextToken();
                map.put(user, nickname);
                
            } else if ( func.equals("Leave") ){
                answer.add(user+"님이 나갔습니다.");
                
            } else if ( func.equals("Change") ){
                String nickname = str.nextToken();
                map.put(user, nickname);
            }
            
            
        }
        
        for (int i=0; i<answer.size(); i++){
            String[] log = answer.get(i).split("님이 ");
            String id = log[0];
            String action = log[1];
            answer.set(i, map.get(id) + "님이 "+ action);
        }
        
        return answer;
    }
    
    
}