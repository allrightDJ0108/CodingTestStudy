import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sorted = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(str.nextToken());
        	sorted[i] = arr[i];
        }
        
        Arrays.sort(sorted);
        
        int cnt = 0;
        //정렬된 상태에서 자신보다 큰 좌표의 개수를 구한다.
        for (int v : sorted) {
        	//자신과 동일한 숫자는 세지 않는다.
        	if (!map.containsKey(v)) {
        		map.put(v, cnt);
        		cnt++;
        	}
        }
        
        for (int key : arr) {
        	sb.append(map.get(key)+" ");
        }
        
        System.out.print(sb);
        
    }
    
    
}
