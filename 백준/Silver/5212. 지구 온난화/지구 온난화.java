import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static char[][] map;
	static char[][] newMap;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());
        
        map = new char[R][C];
        newMap = new char[R][C];
        
        for (int i=0; i<R; i++) {
        	String inp = br.readLine();
        	for (int j=0; j<C; j++) {
        		map[i][j] = inp.charAt(j);
        		newMap[i][j] = inp.charAt(j);
        	}
        }
        
        makeNewMap();
        
        print();
        
    }
    
    static void makeNewMap() {
    	
    	for (int i=0; i<R; i++) {
    		for (int j=0; j<C; j++) {
    			if (map[i][j] == 'X') {
    				int cnt = 0;
    				for (int d=0; d<4; d++) {
    					int nx = i + dir[d][0];
    					int ny = j + dir[d][1];
    					
    					if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
    						if (map[nx][ny] == '.') cnt++;
    					} else cnt++;
    				}
    				
    				if (cnt >= 3) {
    					newMap[i][j] = '.';
    				}
    			}
    		}
    	}
    	//func();
    }
    
    static void print() {
    	int minX = Integer.MAX_VALUE;
    	int minY = Integer.MAX_VALUE;
    	int maxX = Integer.MIN_VALUE;
    	int maxY = Integer.MIN_VALUE;
    	
    	for (int i=0; i<R; i++) {
    		for (int j=0; j<C; j++) {
    			if (newMap[i][j] == 'X') {
    				minX = Math.min(minX, i);
    				minY = Math.min(minY, j);
    				maxX = Math.max(maxX, i);
    				maxY = Math.max(maxY, j);
    			}
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = minX; i <= maxX; i++) {
    		for (int j = minY; j <= maxY; j++) {
    			sb.append(newMap[i][j]);
    		}
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
    }
    
    static void func() {
    	for (int i=0; i<R; i++) {
    		for (int j=0; j<C; j++) {
    			System.out.print(newMap[i][j]);
    		}
    		System.out.println();
    	}
    }
    
    
}
