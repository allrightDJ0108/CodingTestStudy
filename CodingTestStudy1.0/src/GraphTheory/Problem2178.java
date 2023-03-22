package GraphTheory;

import java.io.*;
import java.util.*;

class Problem2178 {
  static int N, M;
  static int[][] arr;
  static int[][] visited;
  static Queue<int[]> q = new LinkedList<>();
  static int cnt = 0;
  static int result = 0;

  static int[] dirX = {-1,1,0,0};
  static int[] dirY = {0,0,-1,1};
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N+1][M+1];
    visited = new int[N+1][M+1];
    
    for (int i=0; i<N; i++){
      String[] str = br.readLine().split("");
      for (int j=0; j<str.length; j++){
        arr[i][j] = Integer.parseInt(str[j]);
      }
    }
    visited[0][0] = cnt++;
    bfsFn(0,0);
    System.out.println(arr[N-1][M-1]);
    
  }

  static void bfsFn(int x, int y){
    q.add(new int[]{x,y});

    while(!q.isEmpty()){
      int[] cur = q.poll();

      for (int i=0; i<4; i++){
        int newX = cur[0] +dirX[i];
        int newY = cur[1] +dirY[i];

        
        if (newX >=0 && newX < N && newY >=0 && newY < M){
          if (arr[newX][newY] == 1 && visited[newX][newY] == 0){
            q.add(new int[]{newX, newY});
            arr[newX][newY] = arr[cur[0]][cur[1]] + 1;
            visited[newX][newY] = cnt++;
          }
        }
      }
    }
  }
}
