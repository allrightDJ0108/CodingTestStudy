import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    static int[][] visited;
    static ArrayList<Integer>[] list;
    static Queue<Integer> q;
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer str = new StringTokenizer(br.readLine(), " ");
      
      N = Integer.parseInt(str.nextToken());
      M = Integer.parseInt(str.nextToken());
      
      visited = new int[N][N];
      list = new ArrayList[N];
      for (int i=0; i<N; i++){
          list[i] = new ArrayList<>();
          Arrays.fill(visited[i], -1); // 초기 거리를 -1로 설정
      }
      
      
      for (int i=0; i<M; i++){
          str = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(str.nextToken()) - 1;
          int b = Integer.parseInt(str.nextToken()) - 1;
          
          list[a].add(b);
          list[b].add(a);
      }
      
      int resultSum = Integer.MAX_VALUE;
      int result = -99;
      
      for (int i=0; i<N; i++){
          
          fun(i);
          
          int sum = 0;
          for (int n : visited[i]){
              sum += n;
          }
          
          if (resultSum > sum){
              resultSum = sum;
              result = i + 1;
          }
          
      }
      
      System.out.println(result);
      
      
    }
    
    static void fun(int start){
        q = new LinkedList<>();
        q.add(start);
        visited[start][start] = 0;
        
        while (!q.isEmpty()){
            int cur = q.poll();
            
            for (int next : list[cur]){
                if (visited[start][next] == -1){
                    q.add(next);
                    visited[start][next] = visited[start][cur] + 1;
                }
            }
        }
    }

}