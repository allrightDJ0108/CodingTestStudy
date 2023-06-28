package Implementation;

import java.io.*;
import java.util.*;

/*다정버전 - 미완성*/
public class Problem16935_re {

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
		arr = new int[N+M][N+M];
		temp = new int[N+M][N+M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = arr[i][j];
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int  i=0; i<R; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp == 1) func01();
			else if (tmp == 2) func02();
			else if (tmp == 3) func03();
			else if (tmp == 4) func04();
			else if (tmp == 5) func05();
			else if (tmp == 6) func06();
		}
		/* 입력부분 */
		
		
		/* 출력부분 */
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (arr[i][j] != 0) sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		/* 출력부분 */
		
	}
	
	static void func01() {
		int tp = 0;
		for (int i=N-1; i>=0; i--) {
			arr[i] = temp[tp++];
		}
		temp = arr;
	}
	
	static void func02() {
		for (int i=0; i<N; i++) {
			int tp = 0;
			for (int j=M-1; j>=0; j--) {
				arr[i][j] = temp[i][tp++];
			}
		}
		temp = arr;
	}
	
	static void func03() {
		int index = 0;
		for (int j=0; j<M; j++) {
			int tmp[] = new int[N+M];
			int tp = N-1;
			for (int i=0; i<N; i++) {
				tmp[tp--] = temp[i][j];
			}
			arr[index++] = tmp;
		}
		int tp = N;
		N = M;
		M = tp;
		temp = arr;
	}
	
	static void func04() {
		int index = 0;
		for (int j=M-1; j>=0; j--) {
			int tmp[] = new int[N+M];
			int tp = 0;
			for (int i=0; i<N; i++) {
				tmp[tp++] = temp[i][j];
			}
			arr[index++] = tmp;
		}
		int tp = N;
		N = M;
		M = tp;
		temp = arr;
	}
	
	static void func05() {
		int midN = N/2;
		int midM = M/2;
		
		//1 > 2
		for (int i=0; i<midN; i++) {
			for (int j=0; j<midM; j++) {
				arr[i][midM+j] = temp[i][j];
			}
		}
		//2 > 3
		for (int i=0; i<midN; i++) {
			for (int j=midM; j<M; j++) {
				arr[midN+i][j] = temp[i][j];
			}
		}
		//3 > 4
		for (int i=midN; i<N; i++) {
			int tmp = 0;
			for (int j=midM; j<M; j++, tmp++) {
				arr[i][tmp] = temp[i][j];
			}
		}
		//4 > 1
		int tmp = 0;
		for (int i=midN; i<N; i++, tmp++) {
			for (int j=0; j<midM; j++) {
				arr[tmp][j] = temp[i][j];
			}
		}
		temp = arr;
	}
	
	static void func06() {
		int midN = N/2;
		int midM = M/2;
		
		//1 > 4
		for (int i=0; i<midN; i++) {
			for (int j=0; j<midM; j++) {
				arr[midN+i][j] = temp[i][j];
			}
		}
		//4 > 3
		for (int i=midN; i<N; i++) {
			for (int j=0; j<midM; j++) {
				arr[i][j+midM] = temp[i][j];
			}
		}
		//3 > 2
		int tmp = 0;
		for (int i=midN; i<N; i++, tmp++) {
			for (int j=midM; j<M; j++) {
				arr[tmp][j] = temp[i][j];
			}
		}
		//2 > 1
		for (int i=0; i<midN; i++) {
			tmp = 0;
			for (int j=midM; j<M; j++, tmp++) {
				arr[i][tmp] = temp[i][j];
			}
		}
		temp = arr;
	}
}
