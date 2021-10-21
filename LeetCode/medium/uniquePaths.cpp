class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(m, vector(n, 0)); 
        dp[0][0] = 1; 
        
        //set up the unique paths
        for(long i = 0; i < n; i++) { //columns
            dp[0][i] = 1; 
        }
        for(long i = 0; i < m; i++) { //rows
            dp[i][0] = 1; 
        }
        
        //dp 
        for(long i = 1; i < m; i++) {
            for(long j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
            }
        }
        
        return dp[m-1][n-1]; 
    }
};
