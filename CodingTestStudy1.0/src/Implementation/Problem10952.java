package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem10952 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer,String> map = new HashMap<Integer,String>();
		
		for (int i=0;i>-1;i++) {
			map.put(i, br.readLine());
			if (map.get(i).equals("0 0")) {
				map.put(i, null);
				i = -100;
			}
		}
		for (int i=0;i<map.size();i++) {
			if (map.get(i) != null) {
				String[] str = map.get(i).split(" ");
				System.out.println(Integer.parseInt(str[0])+Integer.parseInt(str[1]));
			}
		}
		
	}
}
