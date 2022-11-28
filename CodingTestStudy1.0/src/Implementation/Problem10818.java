package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem10818 {

	/*
	//방법1 : Collections 라이브러리 이용
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<>();
		int N = scan.nextInt();
		for (int i=0;i<N;i++) {
			map.put(i, scan.nextInt());
		}
		scan.close();
		
		int max = Collections.max(map.values());
		int min = Collections.min(map.values());
		
		System.out.println(min+" "+max);
	}
	*/
	
	//방법2  : 반복문, StringTokenizer 이용
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
		
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	num[i] = Integer.parseInt(str.nextToken());
        }
        
        int max = num[0];
        int min = num[0];
        
        for (int i=0;i<N;i++) {
        	if (max < num[i]) {
        		max = num[i];
        	}
        	if (min > num[i]) {
        		min = num[i];
        	}
        }
        System.out.println(min+" "+max);
	}
	
}
