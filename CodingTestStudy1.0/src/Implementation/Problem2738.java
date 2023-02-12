package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2738 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		int[][] arr = new int[N][M];
		
		for (int k=0; k<2; k++) {
			for (int i=0; i<N; i++) {
				str = new StringTokenizer(br.readLine());
				for (int j=0; j<M; j++) {
					if (k==0) {
						arr[i][j] = Integer.parseInt(str.nextToken());
					} else {
						arr[i][j] += Integer.parseInt(str.nextToken());
					}
					
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
