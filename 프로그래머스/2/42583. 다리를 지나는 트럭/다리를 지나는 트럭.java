import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] trucks) {
        int answer = 0;
        int sum = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=0; i<trucks.length; i++){
            while (true){
                // 다리가 비어있다면 트럭을 올린다.
                if (q.isEmpty()){
                    q.add(trucks[i]);
                    sum += trucks[i];
                    answer++;
                    break;
                    
                // 다리가 가득 찼다면 트럭을 빼준다. 시간은 걸리지 않는다.
                } else if (q.size() == bridge_length){
                    int out = q.poll();
                    sum -= out;

                } else {
                    // 무게가 된다면 새로운 트럭을 올린다.
                    if (sum + trucks[i] <= weight){
                        q.add(trucks[i]);
                        sum += trucks[i];
                        answer++;
                        break;
                    } else {
                    // 무게가 되지 않으면 0을 올리고 시간을 보낸다.
                        q.add(0);
                        answer++;
                    }
                }
            }
        }
        
        // 마지막 트럭이 다리를 건너는 시간을 더해준다.
        return answer + bridge_length;
    }
}