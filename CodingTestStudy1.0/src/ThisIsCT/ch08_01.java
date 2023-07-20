package ThisIsCT;

public class ch08_01 {
	//Ch08. 다이나믹 프로그래밍 Dynamic Programming DP
	// 피보나치 수열
	
	static int N;
	static long[] d = new long[100];
	
	public static void main(String[] args) {
		N = 10;
		//N을 50으로 설정하면 func1은 결과 반환 불가. func2는 가능
		System.out.println(func1(N));
		System.out.println(func2(N));
	}
	
	//재귀를 이용한 피보나치 수열
	static long func1(int x) {
		
		if (x == 1 || x == 2) {
			return 1;
		}
		
		return func1(x - 1) + func1(x - 2);
	}
	
	//DP - 메모이제이션을 이용한 피보나치 수열
	static long func2(int x) {
		
		if (x == 1 || x == 2) {
			return 1;
		}
		
		if (d[x] > 0) {
			return d[x];
		}
		
		d[x] = func2(x - 1) + func2(x - 2);
		return d[x];
	}
}
