package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for (int i=0;i<10;i++) {
			int res = Integer.parseInt(br.readLine()) % 42;
			map.put(i, res);
		}
		
		System.out.println(map);
	
		
	}
}
