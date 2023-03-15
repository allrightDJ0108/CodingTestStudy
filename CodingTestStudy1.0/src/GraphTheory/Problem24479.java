package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem24479 {
	//다정 풀이 버전 : HashMap 이용
	static StringBuilder sb = new StringBuilder();
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	static int[] visited;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		visited = new int[N+1];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (map.get(x) == null) map.put(x, new ArrayList<Integer>());	//x가 없는 경우 map내에 리스트 생성
			map.get(x).add(y);												//x가 있는 경우 x의 리스트에 값 추가
			if (map.get(y) == null) map.put(y, new ArrayList<Integer>());	//y가 없는 경우 map내에 리스트 생성
			map.get(y).add(x);												//y가 있는 경우 y의 리스트에 값 추가
		}
		
		//오름차순 방문을 위해 정렬
		for (ArrayList<Integer> val : map.values()) {
			Collections.sort(val);
		}
		
		cnt = 1;	//현재 방문 순서 체크
		dfsFn(R);
		
		//결과 출력
		for(int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
	}
	
	public static void dfsFn(int R) {
		visited[R] = cnt;	//현재 방문중인 정점에 순서 저장
		
		if (map.get(R) != null) {	//null체크 (안하면 NullPointer오류 발생)
			for (int i = 0; i < map.get(R).size(); i++) {
				if (visited[map.get(R).get(i)] == 0) {
					cnt++;
					dfsFn(map.get(R).get(i));
				}
			}
		}
	}
}
