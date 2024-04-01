import java.util.*;
class Solution {
    public boolean solution(String password) {
        boolean answer = true;
        char[] arr = password.toCharArray();
        int cnt = 1;
        for (int i=1; i<password.length(); i++){

            if (arr[i] - arr[i-1] == 1 || arr[i] - arr[i-1] == -1) cnt++;
            else cnt = 1;
            if (cnt >= 3) {
                answer = false;
                break;
            }
        }

        return answer;
    }


    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. main 메소드는 잘못된 부분이 없으니, solution 메소드만 수정하세요.
    public static void main(String[] args) {
        Solution sol = new Solution();
        String password1 = "cospro890";
        boolean ret1 = sol.solution(password1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");


        String password2 = "cba323";
        boolean ret2 = sol.solution(password2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2+ " 입니다.");
    }
}