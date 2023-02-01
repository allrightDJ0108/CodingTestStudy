package Implementation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
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
		
		for (int i=0; i<N; i++) {
			int rank = 1;
			for (int j=0; j<N; j++) {
				if (X[i] < X[j] && Y[i] < Y[j]) {
						rank++;
				}
			}
			
			System.out.print(rank + " ");
		}
		
	}
	
}
	


