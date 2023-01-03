package Implementation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String[] arr = str.split(" ");
		
		int A = Integer.parseInt(arr[0]);	//고정비용
		int B = Integer.parseInt(arr[1]);	//가변비용
		int C = Integer.parseInt(arr[2]);	//판매비용
		
		//총 수입 = C * N
		//총 비용 = A + (B * N)
		
		int N = 0;
		
		if ( C - B == 0 ) {
			N = -1;
		} else {
			N = A / (C - B) + 1;
		}
		
		if (N < 0) N = -1;
		
		System.out.println(N);
		
	}
	
}

	


