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
        int indexR = 0; 
        int indexC = 0;
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
        
        int maxSquare = maxR * maxC;
        int minSquare = inp[(indexR + 3) % 6] * inp[(indexC + 3) % 6];
        
		int area = (maxSquare - minSquare) * K;
		
        System.out.println(area);
        
    }
}
