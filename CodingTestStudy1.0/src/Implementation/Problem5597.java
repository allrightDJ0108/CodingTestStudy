package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem5597 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for (int i=1;i<=30;i++) {
			map.put(i, 1);
		}
		
		for (int i=1;i<=28;i++) {
			map.put(Integer.parseInt(br.readLine()), 0);
		}

		for (int i=1;i<=map.size();i++) {
			if ((int)map.get(i) > 0)	System.out.println(i);
		}
		
	}
}
