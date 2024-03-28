package src.Implementation;

import java.io.*;
import java.util.*;

public class Problem1966 {

    static int T, N, M;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            StringTokenizer str = new StringTokenizer(br.readLine());
            N = Integer.parseInt(str.nextToken());
            M = Integer.parseInt(str.nextToken());

            int[] arr = new int[N]; //우선순위를 저장
            Queue<Integer> q = new LinkedList<>();

            str = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++){
                arr[i] = Integer.parseInt(str.nextToken());
                q.add(i);
            }

            func(arr, q);
        }
    }

    static void func(int[] arr, Queue<Integer> q){

        int cnt = 1;
        int[] visited = new int[arr.length];

        while (!q.isEmpty()){
            int cur = q.poll();
            int pir = arr[cur];


            boolean flag = true;
            for (int i=0; i<N; i++){
                //우선순위가 더 높은 것이 있다면
                if (i != cur && pir < arr[i]){
                    flag = false;
                    break;
                }
            }

            if (flag){
                arr[cur] = 0;
                visited[cur] = cnt++;
            } else {
                q.add(cur);
            }
        }

        System.out.println(visited[M]);
    }


}