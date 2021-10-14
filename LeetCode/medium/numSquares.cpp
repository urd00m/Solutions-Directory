class Solution {
public:
    int numSquares(int n) {
        vector<int> squares(100, 0);
        for(long i = 1; i <= 100; i++) {
            squares[i-1] = i*i; 
        }
        vector<int> dp(n+1, 0); 
        dp[0] = 0; 
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < 100; j++) {
                if(i+squares[j] > n) break; 
                if(dp[i+squares[j]] == 0)
                    dp[i+squares[j]] = dp[i] + 1; 
                dp[i+squares[j]] = dp[i]+1 < dp[i+squares[j]] ? dp[i]+1 : dp[i+squares[j]]; 
            }
        }
        return dp[n];
    }
};
