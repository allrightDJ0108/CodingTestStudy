package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem4344 {
	public static void main(String[] args) throws IOException {
		//22.12.04 풀지 못해따ㅠㅠ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		
		Map<Integer,String> map = new HashMap<Integer, String>();
		
		for (int i=0;i<C;i++) {
			map.put(i, br.readLine());
		}
		
		double avg = 0;
		String[] str = null;
		double cnt = 0;
		for (int i=0;i<C;i++) {
			avg = 0;
			cnt = 0;
			
			str = String.valueOf(map.get(i)).split(" ");
			
			for (int j=0;j<str.length;j++) {
				if (j != 0 ) avg += Double.parseDouble(str[j]);
			}
			avg = avg/Double.parseDouble(str[0]);
			System.out.println(str[0]);
			System.out.println(avg);
			
			for (int j=0;j<str.length;j++) {
				if (Double.parseDouble(str[j]) > avg) {
					cnt++;
				}
			}
			cnt = cnt/Double.parseDouble(str[0])*100.0;
			//System.out.println(String.format("%.3f", cnt)+"%");
			System.out.printf("%.3f%%\n",cnt);
		}
		
		
	}
}
