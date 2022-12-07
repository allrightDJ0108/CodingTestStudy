package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem5430 {
	//2022.12.07 시간초과로 실패
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		String str = "";
		String num = "";
		
		Map<Integer, String> mapStr = new HashMap<Integer, String>();
		Map<Integer, String> mapNum = new HashMap<Integer, String>();
		
		for (int i=0;i<T;i++) {
			str = br.readLine();
			int n = Integer.parseInt(br.readLine()); 
			num = br.readLine();
			mapStr.put(i, str);
			mapNum.put(i, num);
		}
		
		for (int i=0;i<mapStr.size();i++) {
			String[] strArr = mapStr.get(i).split("");
			
			for (int j=0;j<strArr.length;j++) {
				if (strArr[j].equals("R")) {
					mapNum.put(i, R(mapNum.get(i)));
				} else if (strArr[j].equals("D")) {
					mapNum.put(i, D(mapNum.get(i)));
				} else {
					mapNum.put(i,"error");
				}
			}
			System.out.println(mapNum.get(i));
		}
		
	}
	
	static String R(String str) {
		str = str.substring(1,str.length()-1);
		String[] arr = str.split(",");
		String[] arrSub = str.split(",");
		int num = arr.length - 1;
		for (int i=0; i<arr.length; i++) {
			arr[i] = arrSub[num];
			num--;
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for (int i=0; i<arr.length; i++) {
			sb.append(arr[i]);
			if (i != arr.length-1) sb.append(",");
		}
		sb.append("]");
		
		return sb.toString();
		
	}
	
	static String D(String str) {
		str = str.substring(1, str.length()-1);
		if (str.length() < 1) return "error";
		
		String[] arr = str.split(",");
		if (arr.length < 1) return "error";
		
		String[] arrSub = new String[arr.length-1]; 
		for (int i=0;i<arrSub.length;i++) {
			arrSub[i] = arr[i+1];
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i=0; i<arrSub.length; i++) {
			sb.append(arrSub[i]);
			if (i != arrSub.length-1) sb.append(",");
		}
		sb.append("]");
		
		return sb.toString();
	}
	
}
