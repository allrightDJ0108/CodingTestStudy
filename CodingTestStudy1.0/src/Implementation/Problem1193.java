package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		int cnt = 1;	//그룹숫자
		int sum = 1;	//누적된 분수번호
		
		if (X == 1) {
			cnt = 1;
		} else {
			while (sum < X) {
				cnt++;
				sum += cnt;
			}
		}
		
		int x = X - (sum - cnt);	//그룹숫자 내에서 몇번째 그룹인지
		
		if (cnt % 2 == 0) {
			//그룹숫자가 짝수일 때 (오름차, 내림차)
			int j = cnt;
			for (int i=1; i <= cnt; i++) {
				if (i == x) System.out.println(i+"/"+ j);
				j--;
			}
			
		} else {
			//그룹숫자가 홀수일 때 (내림차, 오름차)
			int j = 1;
			for (int i=cnt; i >= 1; i--) {
				if (j == x) System.out.println(i+"/"+ j);
				j++;
			}
		}
		
	}
}
