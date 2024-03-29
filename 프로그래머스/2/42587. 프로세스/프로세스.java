import java.util.*;
import java.math.*;


class Solution {
    public int solution(int[] pri, int location) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<pri.length; i++){
            q.add(i);
        }
        
        // int cnt = 1;
        // int[] visited = new int[pri.length];
        
        while (!q.isEmpty()){
            int cur = q.poll(); 
            int max = pri[cur]; 
            for (int i=0; i<pri.length; i++){
                if (cur != i){
                    if (max < pri[i]) {
                        max = pri[i];
                        break;
                    }
                }
            }
            
            if (max == pri[cur]) {
                //visited[cur] = cnt++;
                answer++;
                pri[cur] = 0;
                if (cur == location) return answer;
            }
            else q.add(cur);
            
            
            
        }
        
        //return visited[location];
        return answer;
    }
}