import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0; i<progresses.length; i++){
            int work = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) work++;
            arr.add(work);
            //System.out.println(work);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int cnt = 1;
        int start = arr.get(0);
        for (int i=1; i < arr.size(); i++){
            if (start < arr.get(i)) {
                answer.add(cnt);
                cnt = 1;
                start = arr.get(i);
            } else {
                cnt++;
            }
            
        }
        answer.add(cnt);
        
        return answer;
    }
}