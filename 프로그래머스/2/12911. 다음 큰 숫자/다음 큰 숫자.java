import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int next = n+1;
        int nCnt = binaryFunc(n);
        
        while (true){
            if (binaryFunc(next) == nCnt) {
                answer = next;
                break;
            }
            else next++;
        }
        
        return answer;
    }
    
    static int binaryFunc(int n){
        
        int cnt = 1; // 가장 첫 자리 1을 먼저 개수에 포함
        
        while (n != 1){
            if (n % 2 == 1) cnt++; // 이진수로 변환하면서 1의 개수 카운트
            n = n / 2;
        }
        
        
        //System.out.println(cnt);
        return cnt;
    }
}
