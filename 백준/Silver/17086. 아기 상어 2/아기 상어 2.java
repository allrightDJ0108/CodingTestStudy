import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    static int[][] map;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
    static Queue<int[]> q = new LinkedList<>();
    static int[][] visited;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        
        map = new int [N][M];
        visited = new int [N][M];
        
        for (int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(str.nextToken());
                if (map[i][j] == 1) {
                    q.add(new int[] {i,j});
                    visited[i][j] = 1;
                }
            }
        }
        
        findShark();
        
        int result = Integer.MIN_VALUE;
        
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (map[i][j] == 0){
                    result = Math.max(result, visited[i][j]);
                }
                
            }
        }
        
        System.out.println(result - 1);
        
    }
    
    static void findShark(){
        
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for (int d=0; d<8; d++){
                int nx = cx + dir[d][0];
                int ny = cy + dir[d][1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0 ) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
            
        }
        
        //out();
        
    }
    
    static void out(){
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                System.out.print(visited[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println("===");
    }
}