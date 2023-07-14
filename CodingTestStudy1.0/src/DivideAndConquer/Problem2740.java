package DivideAndConquer;

import java.io.*;


public class Problem2740 {
	
	//행렬곱셈
	//일반적인 풀이 (3중 for문)
	
	static String[] input;
	static int N, M, K;
	static int[][] A;
	static int[][] B;
	static int[][] res;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		A = new int[N][M];
		
		makeArr(N,M,A);
		
		input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		B = new int[M][K];
		
		makeArr(M,K,B);
		
		//N*M, M*K 행렬 곱셈의 결과는 N*K
		res = new int[N][K];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<K; j++) {
				for (int k=0; k<M; k++) {
					res[i][j] += A[i][k] * B[k][j];
				}
				
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<K; j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void makeArr(int x, int y, int[][] arr) throws IOException {
		for (int i=0; i<x; i++) {
			input = br.readLine().split(" ");
			for (int j=0; j<y; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
	}
}
