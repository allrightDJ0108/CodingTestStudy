import java.util.*;

class Solution {
    static int[][] pad = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-2}};
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static String hand;
    static int Lw = -1; 
    static int Rw = -2;
    
    public String solution(int[] numbers, String h) {
        String answer = "";
        if (h.equals("left")) hand = "L";
        if (h.equals("right")) hand = "R";
        for (int n : numbers){
            if (n == 1 || n == 4 || n == 7 ) {
                answer += "L";
                Lw = n;
            }
            else if ( n == 3 || n == 6 || n == 9) {
                answer += "R";
                Rw = n;
            }
            else {
                answer += finger(n);
            }
        }
        return answer;
    }
    
    static String finger(int Nw){
        int[] curL = where(Lw);
        int[] curR = where(Rw);
        int[] curN = where(Nw);
        
        
        int disL = distance(curL, curN);
        int disR = distance(curR, curN);
        
        // System.out.println("Next==="+ Nw);
        // System.out.println("where==="+ Lw+" "+Rw);
        // System.out.println("dis==="+ disL+" "+disR);
        
        if (disL == disR){
            if (hand.equals("L")) Lw = Nw;
            else Rw = Nw;
            return hand;
        } else if (disL > disR){
            Rw = Nw;
            return "R";
        } else 
            Lw = Nw;
            return "L";
    }
    
    static int[] where(int num){
        
        for (int i=0; i<4; i++){
            for (int j=0; j<3; j++){
                if (num == pad[i][j]){
                    return new int[]{i,j};
                }
            }
        }
        
        return new int[]{0,0};
    }
    
    static int distance(int cur[], int Next[]){
        int distance = Math.abs(cur[0] - Next[0]) + Math.abs(cur[1] - Next[1]);
       
        return distance;
        
    }
}