package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem2667 {
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	static int cnt = 0;
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			String[] temp = br.readLine().split("");
			for (int j=0; j<N; j++) {
				if (map.get(i) == null) map.put(i, new ArrayList<Integer>());
				map.get(i).add(Integer.parseInt(temp[j]));
			}
		}
		
		System.out.println(map);
		
		dfsFn(0);
		
	}
	
	static void dfsFn(int R) {
		
		if (map.get(R) != null) {
			for (int i=0; i<map.get(R).size(); i++) {
				if (i+1 < map.get(R).size()) {
					int a = map.get(R).get(i);
					int b = map.get(R).get(i+1);
					if (a == 1 && b == 1) cnt++;
				}
			}
		}
	}

}
