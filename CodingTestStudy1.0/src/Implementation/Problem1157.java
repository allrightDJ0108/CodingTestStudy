package Implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1157 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		char[] word = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < word.length ; i++){
			int count = (map.get(Character.toUpperCase(word[i])) == null) ? 0 : (int)map.get(Character.toUpperCase(word[i]));
			if (count == 0) {
				map.put(Character.toUpperCase(word[i]), 1);
			} else {
				map.put(Character.toUpperCase(word[i]), count + 1);
			}
		}
		
		int max = 0;
		char maxCr = 0;
			for (char key: map.keySet()) {
				//System.out.println(key +" "+map.get(key));
				
				if ((int)map.get(key) > max) {
					max = (int)map.get(key);
					maxCr = key;
				} else if ((int)map.get(key) == max) {
					maxCr = '?';
				}
			}
			
			System.out.println(maxCr);
		
		scan.close();
	}
	
	
}
