// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {

    public int check_map(int[][] map){
        int cnt = 0;
        for (int i=0; i<8; i++){
            for (int j=7; j>=0; j--){
                if (map[i][j] == 0) cnt++;
                //System.out.print(map[i][j]+" ");
            }
            //System.out.println();
        }
        return cnt;
    }
    public int solution(String[] bishops) {
        // 여기에 코드를 작성해주세요.

        int[][] dir = {{1,1}, {-1,1}, {1,-1}, {-1,-1}};
        int[][] map = new int[8][8];
        for (String bishop : bishops){
            int x = bishop.charAt(0) - 'A';
            int y = bishop.charAt(1) - '1';
            map[x][y] = 1;

            //System.out.println(x+" "+y);

            for (int i=0; i<4; i++){
                int cx = x; int cy = y;
                for (int j=0; j<8; j++){
                    int nx = cx + dir[i][0];
                    int ny = cy + dir[i][1];

                    if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8 || map[nx][ny] != 0){
                        cx = nx; cy = ny;
                        continue;
                    } else {
                        map[nx][ny] = 1;
                        cx = nx; cy = ny;
                    }
                }
            }

            check_map(map);
        }

        int answer = check_map(map);

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] bishops1 = {new String("D5")};
        int ret1 = sol.solution(bishops1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        String[] bishops2 = {new String("D5"), new String("E8"), new String("G2")};
        int ret2 = sol.solution(bishops2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}