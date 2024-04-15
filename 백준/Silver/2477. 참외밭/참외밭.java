import java.io.*;
import java.util.*;

public class Main {
	
	static int K;
	

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");
        
        K = Integer.parseInt(str.nextToken());
        
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        int indexR = 0; int indexC = 0;
        int[] inp = new int[6];
        
        for (int i=0; i<6; i++) {
        	str = new StringTokenizer(br.readLine(), " ");
        	int d = Integer.parseInt(str.nextToken());
        	int len = Integer.parseInt(str.nextToken());
        	
        	if (d == 1 || d == 2) {
        		maxR = Math.max(maxR, len);
        		if (maxR == len) indexR = i;
        	} else if (d == 3 || d == 4) {
        		maxC = Math.max(maxC, len);
        		if (maxC == len) indexC = i;
        	}
        	
        	inp[i] = len;
        }
        
        int nextR1 = inp[5], nextC1=inp[5]; // nextR1,R2 => 세로길이 후보
		int nextR2 = inp[0], nextC2=inp[0]; // nextC1,C2 => 가로길이 후보
		if (indexC-1>-1) nextR1=inp[indexC-1];
		if (indexC+1<6) nextR2=inp[indexC+1];
		if (indexR-1>-1) nextC1=inp[indexR-1];
		if (indexR+1<6) nextC2=inp[indexR+1];
		
		// 최대 가로길이*세로길이후보 중 작은 길이 + 가로길이후보 중 작은 길이*(최대 세로길이-세로길이후보 중 작은 길이)
		int area = maxC * Math.min(nextR1, nextR2) + Math.min(nextC1, nextC2) * (maxR - (Math.min(nextR1, nextR2)));
		area = area * K;
		
        System.out.println(area);
        
    }
}
