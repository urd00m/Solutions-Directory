class Solution {
public:
    int integerBreak(int n) {
        // dp 
        // n by 58 (n left over by k integers)
        vector<vector<int>> dp = vector(58, vector(n+1, 0));  
        // fill first level
        for(int i = 1; i < n; i++) {
            dp[1][n-i] = i; 
        }
        
        for(int i = 1; i < 57; i++) {
            for(int j = 1; j < n+1; j++) {
                
                // break of integer of size k 
                for(int k = 0; k <= j; k++) {
                    dp[i+1][j-k] = max(dp[i+1][j-k], dp[i][j] * k);
                }
            }
        }
        
        int ret = 0; 
        for(int i = 0; i < 58; i++) ret = max(ret, dp[i][0]); 
        
        // find max of all breaks 
        return ret; 
    }
};
