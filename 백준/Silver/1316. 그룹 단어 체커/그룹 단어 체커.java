import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
		
			String str = br.readLine();
			boolean bool = true;
			Map<Character, Integer> strMap = new HashMap<Character, Integer>();
			
			//그룹단어 판단
			for (int j=0; j<str.length();j++) {
				char ch = str.charAt(j);
				
				if (strMap.containsKey(ch)) {
					if (j > 0) {
						if (str.charAt(j-1) == ch) {
							bool = true;
							strMap.put(ch, 1);
						} else {
							bool = false;
							j = str.length();
						}
					}
					
				} else {
					bool = true;
					strMap.put(ch, 1);
				}
			}
			
			if (bool) cnt++;
		}
		
		System.out.println(cnt);
		
	}
	
}