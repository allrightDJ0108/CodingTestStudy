package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15596 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		System.out.println(sum(a));
	}
	
	static long sum(int[] a) {
		long sum = 0;
		for (int i=0;i<a.length;i++) {
			sum += a[i];
		}
		return sum;
	}

}


//제출한 답안
/*
public class Test {
    long sum(int[] a) {
        long ans = 0;
        for (int i=0;i<a.length;i++) {
			ans += a[i];
		}
        return ans;
    }
}
*/