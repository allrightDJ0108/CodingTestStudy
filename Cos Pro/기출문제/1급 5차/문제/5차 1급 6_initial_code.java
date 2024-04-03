// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    public String solution(String s1, String s2, int p, int q) {
        // 여기에 코드를 작성해주세요.
        String answer = "";
        int num1 = 0;
        int num2 = 0;

        // p진법의 숫자를 10진수로 변환 - 변환 시 지수가 반대로 되는 것 주의! (s.length() - 1 - i)
        for (int i=0; i<s1.length(); i++){
            num1 += (s1.charAt(i)-'0') * Math.pow(p,s1.length() - 1 - i);
        }
        for (int i=0; i<s2.length(); i++){
            num2 += (s2.charAt(i)-'0') * Math.pow(p,s2.length() - 1 - i);
        }

        int num = num1 + num2;

        // 10진수를 다시 q진법으로 변환
        StringBuilder sb = new StringBuilder();
        while (true){
            sb.append(num % q);
            num /= q;

            if (num < q){
                sb.append(num % q);
                break;
            }
        }

        answer = sb.reverse().toString();

        return answer;
    }


    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.	
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String s1 = new String("112001");
        String s2 = new String("12010");
        int p = 3;
        int q = 8;
    	String ret = sol.solution(s1, s2, p, q);
    	
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
   }
}