package Implementation;

import java.io.*;
import java.util.*;

public class Problem10811 {
	//230301 푸는중
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for (int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		
		int a=0;
		while(a++ < M) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			
			int index = i;
			int temp = 0;
			while (j >= index) {
				System.out.print(arr[i]);
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;j--;
			}
			
		}
		
		System.out.println("==============");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
	}
}
