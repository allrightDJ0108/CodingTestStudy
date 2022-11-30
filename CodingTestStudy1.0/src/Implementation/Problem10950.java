package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem10950 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String[] num = new String[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i=0; i<T; i++) {
			num = br.readLine().split(" ");
			map.put(i,Integer.parseInt(num[0]) + Integer.parseInt(num[1]));
		}
		/*
		for (Integer key : map.keySet()){
			System.out.println(map.get(key));
	    }
	    */
		for (int i=0;i<map.size();i++){
			System.out.println(map.get(i));
	    }
		
	}
}
