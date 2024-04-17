class Solution {
    static int answer = 0;
    
    public int solution(int a, int b, int n) {
        
        return colla(a, b, n);
    }
    
    static int colla(int a, int b, int n){
        if (n < a) return answer;
        
        int out = n / a * a;
        int plus = n / a * b;
        
        n = n - out + plus;
        answer += plus;
        
        return colla(a, b, n);
    }
}