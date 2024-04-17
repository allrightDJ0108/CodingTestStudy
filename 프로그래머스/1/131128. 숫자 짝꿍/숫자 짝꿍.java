import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        int[] numX = new int[10];
        int[] numY = new int[10];
        
        // X의 숫자들을 숫자 배열에 카운트
        for (int i=0; i<X.length(); i++){
            int n = X.charAt(i) - '0';
            numX[n]++;
        }
        //func(numX);
        
        // Y의 숫자들을 숫자 배열에 카운트
        for (int i=0; i<Y.length(); i++){
            int n = Y.charAt(i) - '0';
            numY[n]++;
        }
        //func(numY);
        
        // X, Y 배열에서 숫자가 0보다 크면 작은값 만큼 sb에 넣어줌
        StringBuilder sb = new StringBuilder();
        
        for (int i=9; i>=0; i--){
            if (numX[i] > 0 && numY[i] > 0){
                int min = Math.min(numX[i], numY[i]);
                for (int j=0; j<min; j++){
                    sb.append(i);
                }
            }
        }
        
        answer = sb.toString();
        
        if (answer.equals("")) answer = "-1";
        else if (answer.charAt(0) == '0') answer = "0";
        
        return answer;
    }
    
    static void func(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}