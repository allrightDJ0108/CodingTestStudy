package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int cnt = 0;
		
		for (int i=0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if (ch == 'c') {
				if (i < str.length() - 1) {
					if (str.charAt(i+1) == '=') {
						i++;
					} else if (str.charAt(i+1) == '-') {
						i++;
					}
				}
			} else if (ch == 'd') {
				if (i < str.length() - 1) {
					if (str.charAt(i+1) == 'z') {
						if (i < str.length() - 2) {
							if (str.charAt(i+2) == '=') {
								i+=2;
							}
						}
					} else if (str.charAt(i+1) == '-') {
						i++;
					}
				}
			} else if (ch == 'l') {
				if (i < str.length() - 1) {
					if (str.charAt(i+1) == 'j') {
						i++;
					} 
				}
			} else if (ch == 'n') {
				if (i < str.length() - 1) {
					if (str.charAt(i+1) == 'j') {
						i++;
					} 
				}
			} else if (ch == 's') {
				if (i < str.length() - 1) {
					if (str.charAt(i+1) == '=') {
						i++;
					} 
				}
			} else if (ch == 'z') {
				if (i < str.length() - 1) {
					if (str.charAt(i+1) == '=') {
						i++;
					} 
				}
			} 
			
			cnt++;
		}
		
		System.out.println(cnt);
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		for (int i=0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if (ch == 'c') {
				if (i < str.length() - 1) {
					if (str.charAt(i+1) == '=') {
						map.put(i, String.valueOf(ch) + String.valueOf(str.charAt(i+1)) );
						i++;
					} else if (str.charAt(i+1) == '-') {
						map.put(i, String.valueOf(ch) + String.valueOf(str.charAt(i+1)) );
						i++;
					} else {
						map.put(i, String.valueOf(ch));
					}
				}
			} else if (ch == 'd') {
				if (i < str.length() - 1) {
					if (str.charAt(i+1) == 'z') {
						if (str.charAt(i+2) == '=') {
							map.put(i, String.valueOf(ch) + String.valueOf(str.charAt(i+1)) + String.valueOf(str.charAt(i+2)) );
							i+=2;
						}
					} else if (str.charAt(i+1) == '-') {
						map.put(i, String.valueOf(ch) + String.valueOf(str.charAt(i+1)) );
						i++;
					} else {
						map.put(i, String.valueOf(ch));
					}
				}
			} else if (ch == 'l') {
				if (i < str.length() - 1) {
					if (str.charAt(i+1) == 'j') {
						map.put(i, String.valueOf(ch) + String.valueOf(str.charAt(i+1)) );
						i++;
					} else {
						map.put(i, String.valueOf(ch));
					}
				}
			} else if (ch == 'n') {
				if (i < str.length() - 1) {
					if (str.charAt(i+1) == 'j') {
						map.put(i, String.valueOf(ch) + String.valueOf(str.charAt(i+1)) );
						i++;
					} else {
						map.put(i, String.valueOf(ch));
					}
				}
			} else if (ch == 's') {
				if (i < str.length() - 1) {
					if (str.charAt(i+1) == '=') {
						map.put(i, String.valueOf(ch) + String.valueOf(str.charAt(i+1)) );
						i++;
					} else {
						map.put(i, String.valueOf(ch));
					}
				}
			} else if (ch == 'z') {
				if (i < str.length() - 1) {
					if (str.charAt(i+1) == '=') {
						map.put(i, String.valueOf(ch) + String.valueOf(str.charAt(i+1)) );
						i++;
					} else {
						map.put(i, String.valueOf(ch));
					}
				}
			} else {
				map.put(i, String.valueOf(ch));
			}
			
		}
		
		System.out.println( map.size());
	}
	*/
}
}

/*
if (i < str.length() - 1) {
	if (str.charAt(i) == 'c' && str.charAt(i+1) == '=') {
		map.put(i, String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1)) );
		i++;
	} else if (str.charAt(i) == 'c' && str.charAt(i+1) == '-') {
		map.put(i, String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1)) );
		i++;
	} else if (str.charAt(i) == 'd' && str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') {
		map.put(i, String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1)) + String.valueOf(str.charAt(i+2)) );
		i+=2;
	} else if (str.charAt(i) == 'd' && str.charAt(i+1) == '-') {
		map.put(i, String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1)) );
		i++;
	} else if (str.charAt(i) == 'l' && str.charAt(i+1) == 'j') {
		map.put(i, String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1)) );
		i++;
	} else if (str.charAt(i) == 'n' && str.charAt(i+1) == 'j') {
		map.put(i, String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1)) );
		i++;
	} else if (str.charAt(i) == 's' && str.charAt(i+1) == '=') {
		map.put(i, String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1)) );
		i++;
	} else if (str.charAt(i) == 'z' && str.charAt(i+1) == '=') {
		map.put(i, String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1)) );
		i++;
	} else {
		map.put(i, String.valueOf(str.charAt(i)) );
	}
}
*/