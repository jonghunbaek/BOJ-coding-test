class Solution {
    public int solution(int n) {
        int answer = 0;
        if (n%2 != 0) {
            return answer;
        }
        long[] dp = new long[n+1];
        dp[1] = 0;
        dp[2] = 3;
        long temp = 0;
        for (int i=4; i<=n; i+=2) {  
            dp[i] = dp[i-2] * dp[2] + 2 + temp;
            temp += dp[i-2] * 2;
            dp[i] %= 1000000007;
        }
        answer = (int)dp[n];
        return answer;
    }
}