
// You may use import as below.
import java.util.*;

class Solution {

    static int[][] dir = {{-1,-2}, {-2,-1}, {1,-2}, {2,-1}, {2,1}, {1,2}, {-1,2}, {-2,1}};
    public int solution(String pos) {
        // Write code here.
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        int x = -(pos.charAt(1) - 56);
        int y = pos.charAt(0) - 65;

        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i=0; i<8;i++){
                int nx = cx + dir[i][0];
                int ny = cy + dir[i][1];

                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8){
                    answer++;
                }
            }
        }


        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        src.Solution sol = new src.Solution();
        String pos = "A7";
        int ret = sol.solution(pos);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}