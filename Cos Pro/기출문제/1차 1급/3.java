
// You may use import as below.
import java.util.*;

class Solution {

    static int[][] dir = {{-1,-2}, {-2,-1}, {1,-2}, {2,-1}, {2,1}, {1,2}, {-1,2}, {-2,1}};
    public int solution(String pos) {
        // Write code here.
        int answer = 0;
        int cx = pos.charAt(1) - '1'; // 개수만 구하면 되므로 정확한 위치가 중요하지 않음
        int cy = pos.charAt(0) - 'A';

        for (int i=0; i<8;i++){
            int nx = cx + dir[i][0];
            int ny = cy + dir[i][1];

            if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8){
                answer++;
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