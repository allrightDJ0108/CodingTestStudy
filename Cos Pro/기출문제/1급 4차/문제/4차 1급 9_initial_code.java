// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    public String solution(int hour, int minute) {
        // 여기에 코드를 작성해주세요.

        //0을 기준으로 위치가 어디인지 판단
        // 시침은 60분에 360 / 12 = 30도씩 회전 -> 1분에 0.5도씩 회전
        // 분치은 60분에 360도씩 회전 -> 1분에 6도씩 회전

        double h = (int)(30 * hour + 0.5 * minute);
        double m = 6 * minute;

        double ans = Math.abs(m - h);
        if (ans > 180) ans = 360 - ans;

        return String.valueOf(ans);
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int hour = 3;
        int minute = 30;
        String ret = sol.solution(hour, minute);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}