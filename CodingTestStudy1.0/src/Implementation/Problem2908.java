package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2908 {
	
	//방법1
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] array = str.split(" ");
		
		int A = numFn(Integer.parseInt(array[0]));
		int B = numFn(Integer.parseInt(array[1]));
		
		if (A > B) System.out.println(A);
		else System.out.println(B);
	}
	
	static int numFn(int x) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i=0;i<3;i++) {
			map.put(i, x % 10);
			x /= 10;
		}
		x = 0;
		int size = map.size()-1;
		for (Integer key : map.keySet()){
			x += map.get(key) * (int)Math.pow(10, size);
			size--;
	    }
		
		return x;
	}
	*/
	
	//방법2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(new StringBuilder(str.nextToken()).reverse().toString());
		int B = Integer.parseInt(new StringBuilder(str.nextToken()).reverse().toString());
		
		System.out.println(A > B ? A : B);	
	}
	
}
