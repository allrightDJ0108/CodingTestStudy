package Implementation;

import java.io.*;
import java.util.*;

public class Problem16935 {

	static int N,M,R;
	static int[][] arr;
	static int[][] temp;
	
	public static void main(String[] args) throws IOException {
		/* 입력부분 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());	
		arr = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int  i=0; i<R; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			/* 실행부분 */
			if (tmp == 1) func01();
			else if (tmp == 2) func02();
			else if (tmp == 3) func03();
			else if (tmp == 4) func04();
			else if (tmp == 5) func05();
			else if (tmp == 6) func06();
			/* 실행부분 */
		}
		/* 입력부분 */
		
		
		/* 출력부분 */
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		/* 출력부분 */
		
		
	}
	
	static void func01() {
		temp = new int[N][M];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				temp[N-i-1][j] = arr[i][j];
			}
		}
		arr = temp;
	}
	
	static void func02() {
		temp = new int[N][M];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				temp[i][M-j-1] = arr[i][j];
			}
		}
		arr = temp;
	}
	
	static void func03() {
		temp = new int[M][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				temp[j][N-i-1] =  arr[i][j];
			}
		}
		int tp = N;
		N = M;
		M = tp;
		arr = temp;
	}
	
	static void func04() {
		temp = new int[M][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				temp[M-j-1][i] = arr[i][j];
			}
		}
		int tp = N;
		N = M;
		M = tp;
		arr = temp;
	}
	
	static void func05() {
		temp = new int[N][M];
		int midN = N/2;
		int midM = M/2;
		
		//1 > 2
		for (int i=0; i<midN; i++) {
			for (int j=0; j<midM; j++) {
				temp[i][midM+j] = arr[i][j];
			}
		}
		//2 > 3
		for (int i=0; i<midN; i++) {
			for (int j=midM; j<M; j++) {
				temp[midN+i][j] = arr[i][j];
			}
		}
		//3 > 4
		for (int i=midN; i<N; i++) {
			int tmp = 0;
			for (int j=midM; j<M; j++, tmp++) {
				temp[i][tmp] = arr[i][j];
			}
		}
		//4 > 1
		int tmp = 0;
		for (int i=midN; i<N; i++, tmp++) {
			for (int j=0; j<midM; j++) {
				temp[tmp][j] = arr[i][j];
			}
		}
		arr = temp;
	}
	
	static void func06() {
		temp = new int[N][M];
		int midN = N/2;
		int midM = M/2;
		
		//1 > 4
		for (int i=0; i<midN; i++) {
			for (int j=0; j<midM; j++) {
				temp[midN+i][j] = arr[i][j];
			}
		}
		//4 > 3
		for (int i=midN; i<N; i++) {
			for (int j=0; j<midM; j++) {
				temp[i][j+midM] = arr[i][j];
			}
		}
		//3 > 2
		int tmp = 0;
		for (int i=midN; i<N; i++, tmp++) {
			for (int j=midM; j<M; j++) {
				temp[tmp][j] = arr[i][j];
			}
		}
		//2 > 1
		for (int i=0; i<midN; i++) {
			tmp = 0;
			for (int j=midM; j<M; j++, tmp++) {
				temp[i][tmp] = arr[i][j];
			}
		}
		arr = temp;
	}
}
