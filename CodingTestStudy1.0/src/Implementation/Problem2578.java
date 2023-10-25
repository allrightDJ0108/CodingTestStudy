package Implementation;

import java.io.*;
import java.util.*;

public class Problem2578 {
    static int[][] arr;
    static int count = 0;
    static boolean flagR = false; 
    static boolean flagL = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        arr = new int[5][5];
        for (int i=0; i<5; i++){
            str = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        int ind = 0;
        for (int i=0; i<5; i++){
            str = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++){
                int aws = Integer.parseInt(str.nextToken());
                ind++;
                for (int a=0; a<5; a++){
                    for (int b=0; b<5; b++){
                        if (arr[a][b] == aws) {
                            arr[a][b] = 0;
                            count += bingo(a,b);
                            if (!flagR) count += bingoR();
                            if (!flagL) count += bingoL();
                        }
                        if (count == 3){
                            i=6; j=6;
                        }
                    }
                }
            }
        }

        System.out.println(ind);

    }

    static int bingo(int x, int y){
        int cnt = 0;
        int tempX = 0;
        int tempY = 0;
        for (int i=0; i<5; i++){
            
            if (arr[x][i] == 0){
                tempX++;
            }

            if (arr[i][y] == 0){
                tempY++;
            }

        }

        if (tempX == 5){
            cnt++;
        }
        if (tempY == 5){
            cnt++;
        }

        return cnt;
    }
    
    static int bingoR(){
        int cnt = 0;
        int tempR = 0;
        for (int i=0; i<5; i++){
            if (arr[i][i] == 0){
                tempR++;
            }
        }
        if (tempR == 5){
            cnt++;
            flagR = true;
        }
        
        return cnt;
    }
    
    static int bingoL(){
        int cnt = 0;
        int tempL = 0;
        int j=4;
        for (int i=0; i<5; i++, j--){
            if (arr[i][j] == 0){
                tempL++;
            }
        }

    	if (tempL == 5){
            cnt++;
            flagL = true;
        }
        

        return cnt;
    }
}