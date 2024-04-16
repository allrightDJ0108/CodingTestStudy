class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        
        dp[1] = 0;
        dp[2] = 1;
        
        for (int i=3; i<=n; i++){
            if (isPrime(i)){
                dp[i] = dp[i-1] + 1;
            } else dp[i] = dp[i-1];
        }
        
        return dp[n];
    }
    
    static boolean isPrime(int num){
        int sq = (int) Math.sqrt(num);
        for (int i=2; i <= sq; i++){
            if (num % i == 0) return false;
        }
        return true;
    }
}