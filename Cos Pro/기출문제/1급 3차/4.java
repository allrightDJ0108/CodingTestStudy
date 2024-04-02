// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    public int solution(String s1, String s2) {
        // 여기에 코드를 작성해주세요.
        int resultS1 = findString(s1, s2);

        int resultS2 = findString(s2, s1);

        int max = Math.max(resultS1, resultS2);

        int answer = s1.length() + s2.length() - max;
        return answer;
    }

    public int findString(String s1, String s2){
        int size = 0;
        // s1의 뒷부분과 s2의 앞부분을 비교한다.
        for (int i=0; i<s1.length(); i++){
            if (s2.startsWith(s1.substring(i))){
                size = s1.length() - i;
                break;
            }
        }
        return size;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = new String("ababc");
        String s2 = new String("abcdab");
        int ret = sol.solution(s1, s2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}