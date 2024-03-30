package src;

// You may use import as below.
import java.util.*;

import java.util.LinkedList;

class Solution {

    static int[] dt = {1,2,3,4};
    static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}}; //우, 하, 좌, 상
    public int solution(int n) {
        int answer = 0;

        int[][] arr = new int[n][n];
        int[][] visited = new int[n][n];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        arr[0][0] = 1;
        int d = 0;
        int mark = 0;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            int nx = cx + dir[d][0];
            int ny = cy + dir[d][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0 ) {
                d = (d + 1) % 4;
                q.add(new int[]{cx, cy});
            } else {
                arr[nx][ny] = arr[cx][cy] + 1;
                mark = arr[nx][ny];
                q.add(new int[]{nx, ny});
            }

            if (mark == n*n) q.clear();
        }

        // 대각선으로 더하기
        for (int i=0; i<n; i++){
            answer += arr[i][i];
        }

        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        src.Solution sol = new src.Solution();
        int n1 = 3;
        int ret1 = sol.solution(n1);


        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret1 + " .");

        int n2 = 2;
        int ret2 = sol.solution(n2);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret2 + " .");
    }
}
