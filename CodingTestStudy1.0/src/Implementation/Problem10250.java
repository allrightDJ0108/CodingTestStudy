package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0;i<T;i++) {
			map.put(i, br.readLine());
		}
		
		for (int i=0;i<T;i++) {
			String[] str = map.get(i).split(" ");
			
			System.out.println(hotelFn(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2])));
		}
		
	}
	
	static String hotelFn(int H, int W, int N) {
		
		int x, y;		//x는 층, y는 호수
		
		if (N % H == 0) {
			x = H;
			y = N / H;
		}
		else {
			x = N % H;	
			y = (N / H) + 1;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(x);
		if (y < 10) {
			sb.append(0);
		}
		sb.append(y);
		
		
		return sb.toString();
	}
}
