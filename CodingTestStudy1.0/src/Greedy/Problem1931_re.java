package Greedy;

import java.io.*;
import java.util.*;

public class Problem1931_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				
				return o1[1] - o2[1];
			}
		});
        int endTime = Integer.MIN_VALUE;
        int cnt = 0;
        //ArrayList<int []> result = new ArrayList();

        for (int[] time : arr){
            int start = time[0];
            int end = time[1];
            if (start >= endTime){
                endTime = end;
                //result.add(new int[]{start, end});
                cnt++;
            }
        }

        // for (int[] temp : result){
        //     System.out.printf("%d %d\n", temp[0], temp[1]);
        // }

        System.out.println(cnt);
    }
}
