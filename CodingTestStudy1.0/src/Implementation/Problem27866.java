package Implementation;

import java.io.*;
import java.util.*;

public class Problem27866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int i = Integer.parseInt(br.readLine()) - 1;
		
		System.out.println(str.charAt(i));
		
	}
}
