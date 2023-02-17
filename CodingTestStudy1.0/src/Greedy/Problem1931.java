package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem1931 {
	//230217 흑흑 넘 어려워따,,,,ㅠ.ㅠ
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer str;
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(str.nextToken());
			arr[i][1] = Integer.parseInt(str.nextToken());
		}
		
		//끝나는 시간을 기준으로 정렬
		//Arrays.sort(arr);
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				
				return o1[1] - o2[1];
			}
		});
		
		int cnt = 0;
		int temp = 0; //이전 종료시간
		
		for (int i=0; i<N; i++) {
			//이전 종료시간이 다음 회의 시작시간보다 작거나 같으면 갱신
			if (temp <= arr[i][0]) {
				temp = arr[i][1];	//다음 회의를 진행하니까 종료시간 대입
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}
}
