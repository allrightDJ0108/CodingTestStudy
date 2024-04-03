// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    public int solution(int n, int[][] garden) {
        // 여기에 코드를 작성해주세요.
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (garden[i][j] == 1) q.add(new int[]{i,j});
            }
        }

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i=0; i<4; i++){
                int nx = cx + dir[i][0];
                int ny = cy + dir[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && garden[nx][ny] == 0){
                    q.add(new int[]{nx, ny});
                    garden[nx][ny] = garden[cx][cy] + 1;
                    answer = Math.max(answer, garden[nx][ny]);
                }
            }
        }

        if (answer <= 0) answer = 0;
        else answer -= 1;

        return answer;
    }
    
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n1 = 3;
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(n1, garden1);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
        
        int n2 = 2;
        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(n2, garden2);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
        
    }    
}