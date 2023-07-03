package Samsung;

import java.io.*;

public class Problem3107 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String ip = br.readLine();
		String[] arrStr = ip.split(":");
		
		int part = arrStr.length;
		for (String tmp : arrStr) {
            if(tmp.length() == 0) part--;
        }
		
		int idx = 0;	// 입력받은 문자열을 split한 배열의 index
		int cnt = 0;
		
		while ( idx < arrStr.length ) {
			String tmp = arrStr[idx];
			if (tmp.length() == 0 && part < 8) {	// ::로 인해 생략된 부분
				sb.append("0000");
				cnt++;
				part++;		// 빈 구역이 있는지 확인하기 위해 필요
			} else if (tmp.length() == 0) {
				idx++;
				continue;
			} else {
				int tempLen = 4 - tmp.length();
				for (int j=0; j<tempLen; j++) {
					sb.append("0");
				}
				sb.append(tmp);
				idx++; cnt++;
			}
			if (cnt < 8) sb.append(":");
		}
		
		while (cnt < 8) {
			sb.append("0000");
			cnt++;
			if (cnt < 8) sb.append(":");
		}
		
		System.out.println(sb);
		
	}
}
