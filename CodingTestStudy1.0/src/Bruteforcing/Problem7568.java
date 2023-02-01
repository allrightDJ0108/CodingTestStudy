package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem7568 {
	static int N;
	static int[] X,Y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		X = new int[N];
		Y = new int[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(str.nextToken());
			Y[i] = Integer.parseInt(str.nextToken());
		}
		
		func();
		
	}
	
	static void func() {
		int max = 0;
		int min = 0;
		int temp = 0;
		
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				if (X[i] < X[j]) {
					if (Y[i] < Y[j]) {		//덩치가 더 큼
						max = j;
					} else {				//덩치를 비교할 수 없음
						temp++;
					}
				} else {	
					if (Y[i] > Y[j]) { 		//덩치가 더 작음
						min = j;
					} else {
						temp++;
					}
				}
			}
			
		}
		
		int[] rank = new int[N];
		for (int i=0;i<N;i++) {
			rank[i] = 2;
		}
		rank[max] = 1;
		rank[min] = N;
		
		for (int i=0;i<N;i++) {
			System.out.print(rank[i]+" ");
		}
	}
}
