package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem2775 {
	public static void main(String[] args) throws IOException {
		//2775 푸는중
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		for (int i=0;i<T;i++) {
			map.put(i,br.readLine()+" "+ br.readLine());
		}
		
		for (int i=0;i<T;i++) {
			String[] str = map.get(i).split(" ");
			int k = Integer.parseInt(str[0]);	//층
			int n = Integer.parseInt(str[1]);	//호
			
			//한 층에 사는 사람
			int sum = n * (n+1) / 2 * k;
			
		}
		
		System.out.println(map);
	}
}
