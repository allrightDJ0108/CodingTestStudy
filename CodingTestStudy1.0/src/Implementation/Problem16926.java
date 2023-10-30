package Implementation;

import java.io.*;
import java.util.*;

public class Problem16926 {
    static int N, M, R;
    static int[][] arr;
    static int min;
    
    static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};    //상단, 우측, 하단, 좌측 채우기

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        R = Integer.parseInt(str.nextToken());

        arr = new int[N][M];

        for (int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        min = Math.min(N,M);

        for (int i=0; i<R; i++){
            rotateFn();
        }
        printFn();
    }

    static void rotateFn(){
        
        // 회전시켜야 하는 그룹의 개수 : Math.min(N,M) / 2
        for (int t=0; t< (min / 2); t++){
            int x = t;
            int y = t;

            int temp = arr[x][y];
            int idx = 0;
            while (idx < 4){
                int nx = x + dir[idx][0];
                int ny = y + dir[idx][1];

                //System.out.printf("idx : %d. nx : %d / ny : %d \n", idx, nx, ny);

                // 현재 회전시키는 그룹의 범위 내
                if(nx < N-t && ny < M-t && nx >= t && ny >= t) {
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    idx++;
                }
            }

            arr[t+1][t] = temp;
        }

    }

    static void printFn(){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                sb.append(arr[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
