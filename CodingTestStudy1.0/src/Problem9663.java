import java.io.*;
import java.util.*;

public class Problem9663 {

    static int N;
    static int[][] map;

    static int[] v1 ;
    static int[] v2;
    static int[] v3;
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        v1 = new int[N];
        v2 = new int[N*2];
        v3 = new int[N*2];

        dfs(0);

        System.out.println(result);

    }

    static void dfs(int n){
        if (n == N){
            result++;
            return;
        }

        for (int j=0; j<N; j++){
            if (v1[j] == 0 && v2[n+j] == 0 && v3[n-j] == 0){
                v1[j] = v2[n+j] = v3[n-j] = 1;
                dfs(n+1);
                v1[j] = v2[n+j] = v3[n-j] = 0;

            }
        }
    }

}