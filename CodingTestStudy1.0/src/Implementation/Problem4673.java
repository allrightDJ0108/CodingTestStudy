package Implementation;

public class Problem4673 {
	
	public static void main(String[] args) {
		
		boolean[] check = new boolean[100001];
			
		for (int i = 1; i <= 10000 ; i++){
			int n = selfNumber(i);
			
			if ( n < 10001 ) {		//2022.11.15 해당 부분 질문
				check[n] = true;
			}
		}
		
		for (int i = 1; i <= 10000 ; i++){
			if (!check[i]) {
				System.out.println(i);
			}
			
		}
		
		
	}
		
	static int selfNumber(int n) {
		
		int  sum = n;
		
		while (n != 0) {
			sum = sum + n % 10;		//마지막 자리 수부터 더함
			n = n / 10;
		}
		
		return sum;
	}

}
