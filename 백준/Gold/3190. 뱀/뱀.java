import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K, L;
	static int[][] board;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}}; //우, 하, 좌, 상
	static List<int[]> snake = new LinkedList<>();
	static Map<Integer, String> map = new HashMap<>();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str ;
        
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        
        for (int i=0; i<K; i++) {
        	str = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(str.nextToken()) - 1;
        	int y = Integer.parseInt(str.nextToken()) - 1;
        	board[x][y] = 1;
        }
        
        L = Integer.parseInt(br.readLine());
        
        for (int i=0; i<L; i++) {
        	str = new StringTokenizer(br.readLine());
        	int t = Integer.parseInt(str.nextToken());
        	String d = str.nextToken();
        	map.put(t, d);
        }
        
        start();
    }
    
    static void start() {
    	int time = 0;
    	int x = 0; 
    	int y = 0;
    	int d = 0;
    	snake.add(new int[] {x,y});
    	
    	while (true) {
    		
    		time++;
    		
    		x = x + dir[d][0];
    		y = y + dir[d][1];
    		
    		if (isFinished(x,y)) break;
    		
    		if (board[x][y] == 1) {
    			snake.add(new int[] {x,y});
    			board[x][y] = 0;
    		}
    		else {
    			snake.add(new int[] {x,y});
    			snake.remove(0);
    			
    		}
    		
    		if (map.containsKey(time)) {
    			if (map.get(time).equals("D")) {
    				//오른쪽으로 회전
					d += 1;
					if (d == 4) d = 0;
				} else {
					//왼쪽으로 회전
					d -= 1;
					if (d == -1) d = 3;
					
    			}
    		}
    	}
    	
    	System.out.println(time);
    }
    
    static boolean isFinished(int x, int y) {
    	if (x < 0 || x >= N || y < 0 || y >= N) return true;
    	
    	for (int[] cur : snake) {
    		if (cur[0] == x && cur[1] == y) return true;
    	}
    		
    		
    	return false;
    }
    
    
}
