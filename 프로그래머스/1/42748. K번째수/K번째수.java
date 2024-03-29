import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        
        for (int a=0; a<commands.length; a++){
            ArrayList<Integer> arr = new ArrayList<>();
            int i = commands[a][0] - 1;
            int j = commands[a][1] - 1;
            int k = commands[a][2] - 1;
            
            for (int b=i; b <= j; b++){
                arr.add(array[b]);
                
            }
            
            Collections.sort(arr);
            answer.add(arr.get(k));
            
        }
        return answer;
    }
}