package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String[] strArr = new String[T];
		for (int i=0; i<T; i++) {
			strArr[i] = br.readLine();
		}
		
		for (int i=0; i<strArr.length; i++) {
			StringTokenizer str = new StringTokenizer(strArr[i]);
			int R = Integer.parseInt(str.nextToken());
			String[] arr = str.nextToken().split("");
			for (int a=0; a<arr.length;a++) {
				for (int b=0; b<R; b++) {
					System.out.print(arr[a]);
				}
				
			}
			System.out.println();
			
		}
	}

}
