package Programmers;

import java.util.*;

public class Problem60063{
    //블럭 이동하기

    public int map[][];
    public int n;
    public int dx[] = {-1,1,0,0};
    public int dy[] = {0,0,-1,1};
    public boolean row[][];  //행 방문 여부
    public boolean col[][];  //열 방문 여부
    public int answer;

    public static void main(String args[]) {
        solution({{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}});

    }
    public int solution(int[][] board) {
        n = board.length;
        answer = 0;
        row = new boolean[n][n];
        col = new boolean[n][n];
        map = new int[n][n];

        //map을 board 값으로 초기화
        for(int i = 0; i < n; i++)
            map[i] = board[i].clone();

        //row에 시작점(0,0), (0,1) 방문 처리
        row[0][0] = true;
        row[0][1] = true;

        start();

        return answer;
    }

    //하나의 점 위치
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //로봇의 위치(두개의 점)
    class Robot {
        Point p1, p2;
        int dir;
        Robot(Point p1, Point p2, int dir){
            this.p1 = p1;
            this.p2 = p2;
            this.dir = dir;
        }
    }

    //로봇의 위치(두개의 점)
    public boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n && map[x][y] == 0;
    }

    //로봇이 회전을 할 수 있는지 반환
    public boolean rotate(int x1, int y1, int x2, int y2) {
        //로봇이 위치한 두 점 중 하나라도 조건에 맞지 않으면 회전 불가능
        if(!check(x1, y1) || !check(x2, y2))
            return false;

        return true;
    }




    public void start() {
        Queue<Robot> q = new LinkedList<Robot>();
        //로봇이 시작하는 두 점을 q에 추가
        q.add(new Robot(new Point(0,0), new Point(0,1), 0));
        q.add(new Robot(null, null, -1));
        int count = 0;

        while(!q.isEmpty()) {
            Robot now = q.poll();

            if(now.dir == -1) {
                count++;
                if(!q.isEmpty())
                    q.add(new Robot(null, null, -1));
                continue;
            }

            //로봇이 목적지(N-1, N-1)에 도착한 경우 함수 종료
            if((now.p1.x == n-1 && now.p1.y == n-1) || (now.p2.x == n-1 && now.p2.y == n-1)) {
                answer = count;
                break;
            }

            if(now.dir == 0) {
                for(int i = 0; i < 4; i++) {
                    int npx1 = now.p1.x + dx[i];
                    int npy1 = now.p1.y + dy[i];
                    int npx2 = now.p2.x + dx[i];
                    int npy2 = now.p2.y + dy[i];

                    if(check(npx1, npy1) && check(npx2, npy2)) {
                        if(!row[npx1][npy1] || !row[npx2][npy2]) {
                            Robot next = new Robot(new Point(npx1, npy1), new Point(npx2, npy2), 0);
                            row[npx1][npy1] = true;
                            row[npx2][npy2] = true;
                            q.add(next);
                        }
                    }
                }

                for(int i = -1; i <= 1; i+=2) {
                    int npx1 = now.p1.x + i;
                    int npy1 = now.p1.y;
                    int npx2 = now.p2.x + i;
                    int npy2 = now.p2.y;

                    if(check(npx1, npy1) && check(npx2, npy2)) {
                        if(rotate(npx1, npy1, now.p1.x, now.p1.y) && (!col[npx1][npy1] || !col[now.p1.x][now.p1.y])) {
                            col[npx1][npy1] = true;
                            col[now.p1.x][now.p1.y] = true;
                            q.add(new Robot(new Point(npx1, npy1), new Point(now.p1.x, now.p1.y), 1));
                        }
                        if(rotate(npx2, npy2, now.p2.x, now.p2.y) && (!col[npx2][npy2] || !col[now.p2.x][now.p2.y])) {
                            col[npx2][npy2] = true;
                            col[now.p2.x][now.p2.y] = true;
                            q.add(new Robot(new Point(npx2, npy2), new Point(now.p2.x, now.p2.y), 1));
                        }
                    }
                }
            }
            else {
                for(int i = 0; i < 4; i++) {
                    int npx1 = now.p1.x + dx[i];
                    int npy1 = now.p1.y + dy[i];
                    int npx2 = now.p2.x + dx[i];
                    int npy2 = now.p2.y + dy[i];

                    if(check(npx1, npy1) && check(npx2, npy2)) {
                        if(!col[npx1][npy1] || !col[npx2][npy2]) {
                            Robot next = new Robot(new Point(npx1, npy1), new Point(npx2, npy2), 1);
                            col[npx1][npy1] = true;
                            col[npx2][npy2] = true;
                            q.add(next);
                        }
                    }
                }

                for(int i = -1; i <= 1; i+=2) {
                    int npx1 = now.p1.x;
                    int npy1 = now.p1.y + i;
                    int npx2 = now.p2.x;
                    int npy2 = now.p2.y + i;

                    if(check(npx1, npy1) && check(npx2, npy2)) {
                        if(rotate(npx1, npy1, now.p1.x, now.p1.y) && (!row[npx1][npy1] || !row[now.p1.x][now.p1.y])) {
                            row[npx1][npy1] = true;
                            row[now.p1.x][now.p1.y] = true;
                            q.add(new Robot(new Point(npx1, npy1), new Point(now.p1.x, now.p1.y), 0));
                        }
                        if(rotate(npx2, npy2, now.p2.x, now.p2.y) && (!row[npx2][npy2] || !row[now.p2.x][now.p2.y])) {
                            row[npx2][npy2] = true;
                            row[now.p2.x][now.p2.y] = true;
                            q.add(new Robot(new Point(npx2, npy2), new Point(now.p2.x, now.p2.y), 0));
                        }
                    }
                }
            }
        }
    }




}