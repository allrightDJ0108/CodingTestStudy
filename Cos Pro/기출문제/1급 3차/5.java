// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    public String solution(String phrases, int second) {
        // 여기에 코드를 작성해주세요.
        String answer = "";
        String display = "______________" + phrases;

        for (int i=0; i<second; i++){
            // 가장 앞 글자를 맨 뒤에 붙인다
            display = display + display.charAt(0);
            // 가장 앞 글자를 자른다
            display = display.substring(1);

            //System.out.println(display);
        }
        answer = display.substring(0,14);
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        String phrases = new String("happy-birthday");
        int second = 3;
        String ret = sol.solution(phrases, second);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}