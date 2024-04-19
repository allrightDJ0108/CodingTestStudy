import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] board;
	static int[][][] blocks = {
			{{0,0},{0,1},{0,2},{0,3}},
			{{0,0},{1,0},{2,0},{3,0}},
			
			{{0,0},{0,1},{1,1},{1,2}},
			{{0,1},{1,0},{1,1},{2,0}},
			
			{{0,0},{0,1},{0,2},{1,2}},
			{{0,1},{1,1},{2,0},{2,1}},
			{{0,0},{1,0},{1,1},{1,2}},
			{{0,0},{0,1},{1,0},{2,0}},
			
			{{0,0},{0,1},{0,2},{1,1}},
			{{0,1},{1,0},{1,1},{2,1}},
			{{0,1},{1,0},{1,1},{1,2}},
			{{0,0},{1,0},{1,1},{2,0}},
			
			{{0,0},{0,1},{1,0},{1,1}},
	};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        StringBuilder sb = new StringBuilder();
        
        int testCase = 1;
        
        while (true) {
        	
        	N = Integer.parseInt(br.readLine().trim());
        	if (N == 0) break;
            board = new int[N][N];
            
            for (int i=0; i<N; i++) {
            	str = new StringTokenizer(br.readLine()," ");
            	for (int j=0; j<N; j++) {
            		String s = str.nextToken();
            		board[i][j] = Integer.parseInt(s);
            	}
            }
            
            int answer = play();
            
            sb.append(testCase++ +". "+answer).append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    static int play() {
    	int maxSum = Integer.MIN_VALUE;
    	
    	for (int i=0; i<N; i++) {
    		for (int j=0; j<N; j++) {
    			
    			for (int b=0; b<blocks.length; b++) {
    				
    				int sum = 0;
    				boolean flag = true;
    				
    				for (int c=0; c<4; c++) {
    					int nx = i + blocks[b][c][0];
    					int ny = j + blocks[b][c][1];
    					
    					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
    						sum += board[nx][ny];
    					} else {
    						flag = false;
    						break;
    					}
    					
    				}
    				
    				if (flag) {
    					maxSum = Math.max(maxSum, sum);
    				}
					
    			}
    			
    		}
    	}
    	
    	return maxSum;
    }
    
}
