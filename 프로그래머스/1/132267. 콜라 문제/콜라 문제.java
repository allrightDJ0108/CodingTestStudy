class Solution {
    static int answer = 0;
    
    public int solution(int a, int b, int n) {
        
        while (n >= a){
            n = colla(a, b, n);
        }
        return answer;
    }
    
    static int colla(int a, int b, int n){
        int out = n / a * a;
        int plus = n / a * b;
        answer += plus;
        
        return n - out + plus;
    }
}