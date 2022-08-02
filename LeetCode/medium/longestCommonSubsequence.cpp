class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        // dp O(N^2) state O(N^2) update O(1) 
        long n = text1.size(), m = text2.size(); 
        vector<vector<int>> dp = vector(n+1, vector(m+1, 0));  
        
        // one index dp 
        for(long i = 0; i < n; i++) {
            for(long j = 0; j < m; j++) {
                if(text1[i] == text2[j]) 
                    dp[i+1][j+1] = max(dp[i+1][j+1], dp[i][j]+1); 
                
                dp[i+1][j] = max(dp[i+1][j], dp[i][j]); 
                dp[i][j+1] = max(dp[i][j+1], dp[i][j]); 
            }
        }
        
        // scan outer rim
        int ret = 0;
        for(long i = 0; i <= n; i++) ret = max(ret, dp[i][m]);
        for(long i = 0; i <= m; i++) ret = max(ret, dp[n][i]);
        
        return ret; 
    }
};
