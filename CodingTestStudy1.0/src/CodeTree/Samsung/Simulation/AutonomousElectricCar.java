package CodeTree.Samsung.Simulation;

import java.io.*;
import java.util.*;

public class AutonomousElectricCar {

    static int n, m, c;
    static int[][] map;
    static int[][] start;
    static int[][] end;
    static int[] taxi = new int[2];
    static boolean[][] visited;

    static Queue<int[]> q = new LinkedList<>();
    static int[][] dir = {{-1,0}, {1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        c = Integer.parseInt(str.nextToken());

        map = new int[n][n];
        for (int i=0; i<n; i++){
            str = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(str.nextToken());
                if (map[i][j] == 1) map[i][j] = 1;	//벽인 경우 -1로 바꿔줌(승객의 번호가 map에 들어갈 예정)
            }
        }
        
        
        str = new StringTokenizer(br.readLine(), " ");
        taxi[0] = Integer.parseInt(str.nextToken())-1;
        taxi[1] = Integer.parseInt(str.nextToken())-1;

        start = new int[m+1][2];
        end = new int[m+1][2];
        for (int i=1; i<m+1; i++){
            str = new StringTokenizer(br.readLine(), " ");
            start[i][0] = Integer.parseInt(str.nextToken())-1;
            start[i][1] = Integer.parseInt(str.nextToken())-1;
            end[i][0] = Integer.parseInt(str.nextToken())-1;
            end[i][1] = Integer.parseInt(str.nextToken())-1;
            map[start[i][0]][start[i][1]] = i;		//map에 승객의 번호 지정
            
        }

        int answer = -1;
        int cnt = 0;
        while(true) {
        	//택시와 가장 가까운 승객 정보
        	Passenger passInfo = bfsFn(taxi[0], taxi[1]);
        	move(passInfo);
        	
        	if (passInfo.d == 0 || c < 0) break;
        	
        	//승객을 모두 태웠는지 확인
        	cnt++;
        	
        	//승객을 모두 태운 경우 
        	if (cnt == m) {
        		answer = c;
        		break;
        	}
        }
        
        System.out.println(answer);
        
    }
    
    static void move(Passenger passInfo) {
    	int num = passInfo.d;
    	int dis = getDistance(num);
    	//연료 양 줄인 후 충전
    	c -= dis + passInfo.dis;
    	if (c < 0) return;
    	c += (dis * 2);
    	
    	map[start[num][0]][start[num][1]] = 0;
    	taxi[0] = end[num][0];
    	taxi[1] = end[num][1];
    }
    
    static int getDistance(int num) {
    	int dis = Integer.MAX_VALUE;
    	int x = start[num][0];
    	int y = start[num][1];
    	int gx = end[num][0];
    	int gy = end[num][1];
    	
    	q.add(new int[] {x, y, 0});
    	visited = new boolean[n][n];
    	visited[x][y] = true;
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int cx = cur[0];
    		int cy = cur[1];
    		int cd = cur[2];
    		
    		for (int i=0; i<4; i++) {
    			int nx = cx + dir[i][0];
    			int ny = cy + dir[i][1];
    			
    			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
    				continue;
    			}
    			
    			if (map[nx][ny] == -1) {
    				continue;
    			}
    			
    			if (visited[nx][ny]) {
    				continue;
    			}
    			
    			if (nx == gx && ny == gy) {
    				dis = Math.min(cd+1, dis);
    			}
    			
    			q.add(new int[] {nx, ny, cd + 1});
    			visited[nx][ny] = true;
    		}
    	}
    	return dis;
    }

    static Passenger bfsFn(int x, int y){
        q.add(new int[]{x,y,0});
        visited = new boolean[n][n];
        visited[x][y] = true;

        int num = 0;
        int dis = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cd = cur[2];

            for (int i=0; i<4; i++){
                int nx = cx + dir[i][0];
                int ny = cy + dir[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n){
                    continue;
                }

                if (map[nx][ny] == -1){
                    continue;
                }

                if (visited[nx][ny]){
                    continue;
                }

               if (map[nx][ny] > 0) {
            	   dis = cd + 1;
            	   num = map[nx][ny];
               } else if (cd + 1 == dis) {
            	   if (nx < start[num][0]) {
            		   num = map[nx][ny];
            	   } else if (nx == start[num][0] && ny < start[num][1]) {
            		   num = map[nx][ny];
            	   }
               }

                q.add(new int[]{nx, ny, cd + 1});
                visited[nx][ny] = true;
            }
        }

        Passenger minPass = new Passenger(num, dis);
        
        return minPass;
    }

    //현재 위치에서 최단 거리가 가장 짧은 승객 저장
    static class Passenger{
        int d;
        int dis;

        Passenger(int d, int dis){
            this.d = d;
            this.dis = dis;
        }

    }
}