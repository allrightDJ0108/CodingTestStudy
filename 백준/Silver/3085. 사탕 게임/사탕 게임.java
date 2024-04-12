import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		int max = 0;
		
		//보드 채우기
		for (int i=0;i<N;i++) {
			char[] arrCh = br.readLine().toCharArray();
			for (int j=0; j<N;j++) {
				arr[i][j] = arrCh[j];
			}
		}
		
		//가로 기준으로 하나하나씩 바꾸기 작업
		for (int i=0;i<N;i++) {
			for (int j=0; j<N-1;j++) {
				//인접한 칸 바꾸기
				char swap = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = swap;
				//사탕 개수
				max = Math.max(countCandy(arr, N), max);
				//배열 다시 바꾸기
				swap = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = swap;
				
			}
		}
		
		//세로 기준으로 하나하나씩 바꾸기 작업
		for (int i=0;i<N;i++) {
			for (int j=0; j<N-1;j++) {
				//인접한 칸 바꾸기
				char swap = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = swap;
				//사탕 개수
				max = Math.max(countCandy(arr, N), max);
				//배열 다시 바꾸기
				swap = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = swap;
				
			}
		}
		
		System.out.println(max);
		
	}
	
	static int countCandy(char[][] arr, int N) {
		int max = 0;
		
		//가로
		for (int i=0;i<N;i++) {
			int cnt = 1;
			for (int j=0; j<N-1;j++) {
				if (arr[i][j] == arr[i][j+1]) {
					cnt++;
					max = Math.max(max, cnt);
				} else {
					cnt = 1;
				}
				
			}
		}
		
		//세로
		for (int i=0;i<N;i++) {
			int cnt = 1;
			for (int j=0; j<N-1;j++) {
				if (arr[j][i] == arr[j+1][i]) {
					cnt++;
					max = Math.max(max, cnt);
				} else {
					cnt = 1;
				}
			}
		}
		
		return max;
	}
	
	
}