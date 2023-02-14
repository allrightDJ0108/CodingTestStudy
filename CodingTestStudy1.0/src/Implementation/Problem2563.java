package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[100][100];
		
		for (int i=0; i<N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			
			for (int a=x; a<x+10; a++) {
				for (int b=y; b<y+10; b++) {
					arr[a][b] = 1;
				}
			}
			
		}
		
		int cnt = 0;
		for (int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				if (arr[i][j] == 1) cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
