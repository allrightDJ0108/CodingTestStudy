import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] num = new int[T];
		
		String[] str = new String[2];
		for(int i=0; i<T; i++) {
			str = br.readLine().split(" ");
			num[i] = Integer.parseInt(str[0])+Integer.parseInt(str[1]);
		}
		
		for(int i=0; i<T; i++) {
			System.out.println("Case #"+(i+1)+": "+num[i]);
		}
	}
}
