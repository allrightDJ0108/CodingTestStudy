package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2566 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[9][9];
		
		int max = -1;	//입력이 0일수도 있으니 처음 설정을 잘 해야한다!(이거때문에 한참 고민했음 ㅜㅜ)
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<9; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
				if (max < arr[i][j]) {
					max = arr[i][j];
					sb.setLength(0);
					sb.append(i+1).append(" ").append(j+1);
				}
			}
		}
		
		System.out.println(max);
		System.out.println(sb);
		
	}
}
