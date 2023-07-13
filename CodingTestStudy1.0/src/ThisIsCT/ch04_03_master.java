package ThisIsCT;

import java.io.*;

public class ch04_03_master {
	// Ch.04 구현
	// 왕실의 나이트
	// 책에서 풀이한 방법 참고 후 다시 풀어봄.
	
	static int x, y;
	static int[][] steps = {{1,2}, {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		String tempStr = str[0];
		y = Integer.parseInt(str[1]);
		if (tempStr.equals("a")) x = 1;
		else if (tempStr.equals("b")) x = 2;
		else if (tempStr.equals("c")) x = 3;
		else if (tempStr.equals("d")) x = 4;
		else if (tempStr.equals("e")) x = 5;
		else if (tempStr.equals("f")) x = 6;
		else if (tempStr.equals("g")) x = 7;
		else if (tempStr.equals("h")) x = 8;
		
		movingFn();
		System.out.println(result);
	}
	
	static void movingFn() {
		
		for (int[] step : steps) {
			int tempX = x + step[0];
			int tempY = y + step[1];
			
			if (tempX > 0 && tempX <= 8 && tempY > 0 && tempY <= 8) {
				result++;
			}
		}
		
	}
}
