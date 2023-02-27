package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18258 {
	//230227 시간초과남 ㅠㅠ
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] queue = new String[N];
		StringTokenizer st;
		int indexL = 0;
		int indexR = 0;
		int size = 0;
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			sb.setLength(0);
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if (str.equals("push")) {
				queue[indexR] = st.nextToken();
				indexR++;
				size++;
				
			} else if (str.equals("pop")) {
				if (size == 0) { //비어있는지 여부 확인
					sb.append(-1).append("\n");
				} else {
					sb.append(queue[indexL]).append("\n");
					//queue[indexL] = "0";
					indexL++;
					size--;
				}
				
			} else if (str.equals("size")) {
				sb.append(size).append("\n");
				
			} else if (str.equals("empty")) {
				if (size == 0) { //비어있는지 여부 확인
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				
			} else if (str.equals("front")) {
				if (size == 0) { //비어있는지 여부 확인
					sb.append(-1).append("\n");
				} else {
					sb.append(queue[indexL]).append("\n");
				}
				
			} else if (str.equals("back")) {
				if (size == 0) { //비어있는지 여부 확인
					sb.append(-1).append("\n");
				} else {
					sb.append(queue[indexR - 1]).append("\n");
				}
				
			}
			System.out.println(sb);
			
		}
	}
}
