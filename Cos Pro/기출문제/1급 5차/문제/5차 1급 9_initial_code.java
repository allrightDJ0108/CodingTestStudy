// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
	public int solution(int number, int target) {
		// 여기에 코드를 작성해주세요.
		int answer = 0;

		int num = number;

		int cnt = 0;
		int small = 0;
		int big = 0;

		while (true){
			num = num * 2;
			cnt++;
			if (num >= target) {
				small = num / 2;
				big = num;
				break;
			}
		}

		System.out.println(num +" "+cnt+" "+small +" "+big);

		// 차이가 더 작은 쪽을 선택
		if (target - small <= big - target) {
			cnt--;
			while (small != target){
				small += 1;
				cnt++;
			}
		} else {
			while (big != target){
				big -= 1;
				cnt++;
			}
		}


		return cnt;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		Solution sol = new Solution();
		int number1 = 5;
		int target1 = 9;
		int ret1 = sol.solution(number1, target1);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

		int number2 = 3;
		int target2 = 11;
		int ret2 = sol.solution(number2, target2);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
	}
}