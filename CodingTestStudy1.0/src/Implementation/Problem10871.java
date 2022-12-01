package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10871 {
	//방법1
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String[] num = str.split(" ");
		
		int N = Integer.parseInt(num[0]);
		int X = Integer.parseInt(num[1]);
		
		str = br.readLine();
		String[] number = str.split(" ");
		
		for (int i=0;i<N;i++) {
			
			if (Integer.parseInt(number[i]) < X) {
				System.out.print(number[i]);
				System.out.print(" ");
			}
		}
	}
	*/
	
	//방법2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new  StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer .parseInt(st.nextToken());
		int X = Integer .parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			if(value < X) {
				sb.append(value).append(" ");
			}
		}
		System.out.println(sb);
	}
}
