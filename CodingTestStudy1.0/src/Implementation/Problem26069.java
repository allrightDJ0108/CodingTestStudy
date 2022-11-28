package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem26069 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    	int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		Map<String, Integer> map = new HashMap<String, Integer>();	//무지개명단
		
		String[] array = new String[2];
		
		for (int i=0;i<N;i++) {
			str[i] = br.readLine();
		}
		
		for (int i=0;i<N;i++) {
			array = str[i].split(" ");
			
			//총총이는 항상 무지개
			if (array[0].equals("ChongChong")) {
				map.put("ChongChong", 1);
				map.put(array[1], 1);
			} else if (array[1].equals("ChongChong")) {
				map.put("ChongChong", 1);
				map.put(array[0], 1);
			}
			
			if (map.containsKey(array[0])) {
				map.put(array[1], 1);
			} else if (map.containsKey(array[1])) {
				map.put(array[0], 1);
			}
		}
		System.out.println(map.size());
		//System.out.println(map.keySet());
		
	}
		
}
