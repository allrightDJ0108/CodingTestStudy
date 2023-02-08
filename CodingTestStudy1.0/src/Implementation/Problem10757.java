package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Problem10757 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//다시 풀어보기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] num = br.readLine().split(" ");
		
		BigInteger A = new BigInteger(num[0]);
		BigInteger B = new BigInteger(num[1]);
		
		BigInteger ans = A.add(B);
			
		bw.write(ans.toString());

		br.close();
		bw.flush();
		bw.close();
	}
}