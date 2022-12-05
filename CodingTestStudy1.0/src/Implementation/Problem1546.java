package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		for (int i=0;i<N;i++) {
			map.put(i, Integer.parseInt(st.nextToken()));
		}
		int M = Collections.max(map.values());
		double result = 0;
		for (int i=0;i<N;i++) {
			result += ((double)map.get(i))/M*100;
		}
		
		System.out.println(result/N);
		
		
	}
}
