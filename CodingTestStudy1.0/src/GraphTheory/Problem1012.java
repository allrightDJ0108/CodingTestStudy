package GraphTheory;

import java.io.*;
import java.util.*;

public class Problem1012 {

	//다정 풀이
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	static int cnt = 0;
	static int M,N,K;
	
	static int[] dirX = {0,-1,0,1};
	static int[] dirY = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int T = Integer.parseInt(br.readLine());
	    
	    for (int i=0; i<T; i++){
	    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	        M = Integer.parseInt(st.nextToken());
	        N = Integer.parseInt(st.nextToken());
	        K = Integer.parseInt(st.nextToken());
	        
	        arr = new int[M+1][N+1];
	        visited = new int[M+1][N+1];
	        cnt = 0;
	        
	        //배열 입력
	        for (int j=0; j<K; j++){
	        	st = new StringTokenizer(br.readLine(), " ");
	            int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());
	            arr[x][y] = 1;
	        }
	        
	        //DFS, BFS 수행
	        for (int x=0; x<M; x++){
	        	for (int y=0; y<N; y++){
	        		//DFS 풀이1. visited를 이용하는 방법
	        		/*
	        		if (arr[x][y] == 1 && visited[x][y] == 0){
		                dfsFn_1(x, y);
		                cnt++;
	        		}
	        		*/
	        		//DFS 풀이2. visited를 이용하지 않는 방법
	        		/*
	        		if (arr[x][y] == 1) {
	        			dfsFn_2(x, y);
	        			cnt++;
	        		}
	        		*/
	        		//BFS 풀이1. visited를 이용하는 방법
	        		if (arr[x][y] == 1 && visited[x][y] == 0){
		                bfsFn(x, y);
		                cnt++;
	        		}
	            }
	        }
	        System.out.println(cnt);
	    }

	}


	static void dfsFn_1(int x, int y){
	    visited[x][y] = 1;
	
	    for (int cur=0; cur<4; cur++){
	    	int newX = x + dirX[cur];
	    	int newY = y + dirY[cur];
	      
	    	if (newX >= 0 && newY >= 0 && newX < M && newY < N) {
	    		if (arr[newX][newY] == 1 && visited[newX][newY] == 0){
	    			dfsFn_1(newX, newY);
	    		}
	    	}
	    }
	}
	
	static void dfsFn_2(int x, int y){
		arr[x][y] = 0;
		
	    for (int cur=0; cur<4; cur++){
	    	int newX = x + dirX[cur];
	    	int newY = y + dirY[cur];
	      
	    	if (newX >= 0 && newY >= 0 && newX < M && newY < N) {
	    		if (arr[newX][newY] == 1){
	    			dfsFn_2(newX, newY);
	    		}
	    	}
	    }
	}
	
	static void bfsFn(int x, int y){
	    visited[x][y] = 1;
	    q.offer(new int[] {x, y});
	    
	    while(!q.isEmpty()) {
	    	int[] cur = q.poll();
	    	
	    	for (int i=0; i<4; i++){
		    	int newX = cur[0] + dirX[i];
		    	int newY = cur[1] + dirY[i];
		      
		    	if (newX >= 0 && newY >= 0 && newX < M && newY < N) {
		    		if (arr[newX][newY] == 1 && visited[newX][newY] == 0){
		    			q.offer(new int[] {newX,newY});
		    			visited[newX][newY] = 1;
		    		}
		    	}
		    }
	    }
	}
}
