package StudyAlgos;

import java.io.*;

public class Problem18222 {
	static long k;
	static String X = "0";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Long.parseLong(br.readLine());

		String temp = "";
		while (X.length() <= k) {
			for (int i = 0; i < X.length(); i++) {
				if (X.charAt(i) == '0') {
					temp += "1";
				} else {
					temp += "0";
				}
			}
			X += temp;
			temp = "";
		}

		System.out.println(X.charAt((int) k - 1)); // k - 1 번째
	}
}
