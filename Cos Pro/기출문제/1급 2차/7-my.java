// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    public int solution(int money) {
        int answer = 0;
        int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        for (int coin : coins){
            if (money < coin) continue;
            answer += money / coin;
            money = money % coin;
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int money = 2760;
        int ret = sol.solution(money);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}