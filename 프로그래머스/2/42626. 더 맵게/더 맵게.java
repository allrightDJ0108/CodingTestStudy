import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int i=0; i<scoville.length; i++){
            q.add(scoville[i]);
        }
        
        // 우선순위대로 이미 정렬되어 있는 것을 확인할 수 있다.
        //System.out.println(q.toString());
        
        // 큐 내 우선순위가 가장 낮은 것이 K이상이면 종료
        while (q.peek() < K){
            // 큐 내에 음식이 2개 이상이어야 진행 가능
            if (q.size() == 1) return -1;
            
            int first = q.poll();
            int second = q.poll();
            
            q.add(first + second * 2);
            answer++;
        }
        return answer;
    }
}