package DynamicProgramming;

import java.io.*;
import java.util.*;

public class Problem12101 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		ArrayList<String>[] list = new ArrayList[N+3];		//3이하의 입력값 대비
		
		for (int i=0; i < N+3; i++) {
			list[i] = new ArrayList<>();
		}
		
		list[1].add("1");
		
		list[2].add("1+1");
		list[2].add("2");
		
		list[3].add("1+1+1");
		list[3].add("1+2");
		list[3].add("2+1");
		list[3].add("3");
		
		for (int i=4; i < N+1; i++) {
			for (int j=1; j <= 3; j++) {
				for (String st : list[i-j]) {
					list[i].add(st + "+" + j);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if (K > list[N].size()) sb.append(-1);
		else {
			Collections.sort(list[N]);
			sb.append(list[N].get(K-1));
		}
		
		System.out.println(sb);
	}
}
