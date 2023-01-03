package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem11022 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0;i<T;i++) {
			map.put(i,br.readLine());
		}
		
		for (int i=0;i<T;i++) {
			String str = map.get(i);
			
			String[] strArr = str.split(" ");
			System.out.println("Case #" + (i+1) + ": " + strArr[0] + " + "+ strArr[1] + " = "+ (Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1])));
		}
		
	}
}
