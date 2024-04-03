// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
	public int solution(int number, int target) {
		int answer = 0;

		//visited에는 index를 만들기 위한 연산 횟수가 저장
		int[] visited = new int[10001];

		Queue<Integer> q = new LinkedList<Integer>(); //연산의 결과를 넣을 큐(3개씩 나옴)
		q.add(number);
		visited[number]=1; //visited에 number를 방문했음을 기록

		while(!q.isEmpty()){
			int x = q.poll();

			//check(visited, target);
			if(x == target) break; //q에서 가져온 값이 타겟과 같으면 종료

			if(x+1 <=10000 &&  visited[x+1]==0){  //x+1이 방문한 적이 없으면
				visited[x+1]=visited[x]+1; //visited[x]의 방문 횟수에 1을 더해서 visited[x+1]에 저장
				q.add(x+1); //q에 연산 결과를 추가
			}
			if(x-1 >=0 &&  visited[x-1]==0){  //x-1이 방문한 적이 없으면
				visited[x-1]=visited[x]+1; //visited[x]의 방문 횟수에 1을 빼서 visited[x+1]에 저장
				q.add(x-1); //q에 연산 결과를 추가
			}
			if(x*2 <=10000 &&  visited[x*2]==0){  //x*2이 방문한 적이 없으면
				visited[x*2]=visited[x]+1; //visited[x]의 방문 횟수에 2을 곱해서 visited[x+1]에 저장
				q.add(x*2); //q에 연산 결과를 추가
			}
		}
		// target을 만들기 위한 연산 횟수
		answer=visited[target]-1;
		return answer;
	}

	static void check(int[] visited, int target){
		for (int i=0; i<=target; i++){
			System.out.print(visited[i]+" ");
		}
		System.out.println();
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