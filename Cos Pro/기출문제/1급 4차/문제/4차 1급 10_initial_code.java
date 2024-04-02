// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    public int solution(int a, int b) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;

        int cntA = 0;
        int cntB = 0;
        for (int i=a; i<=b; i++){

            for (int j=1; j<=i; j++){
                if (j % 2 != 0 || j == 2) {
                    if (Math.pow(j, 2) == i) cntA++;
                    if (Math.pow(j, 3) == i) cntB++;
                }
            }
        }

        answer = cntA + cntB;
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args){
        Solution sol = new Solution();
        int a = 6;
        int b = 30;
        int ret = sol.solution(a, b);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}