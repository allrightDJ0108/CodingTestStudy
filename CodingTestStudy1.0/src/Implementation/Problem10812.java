package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int[] arr = new int[N+1];
		int[] newArr = new int[N+1];
		
		for (int a=0; a<N; a++) {
			arr[a+1] = a+1;
			newArr[a+1] = a+1;
		}
		
		int i, j, k;
		for (int a=0; a<M; a++) {
			str = new StringTokenizer(br.readLine());
			i = Integer.parseInt(str.nextToken());
			j = Integer.parseInt(str.nextToken());
			k = Integer.parseInt(str.nextToken());
			
			for (int b=i; b<=j; b++) {
				arr[b] = k;
				k++;
				if (k>j) k = i;
			}
			
			System.out.println();
			for (int q=0; q<N; q++) {
				System.out.print(arr[q+1]+" ");
			}
			System.out.println();
		}
		
		
	}
}
