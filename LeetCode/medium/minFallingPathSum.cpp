class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        long n = matrix.size(); 
        if(n == 1) return matrix[0][0]; 
        
        vector<vector<int>> dp = vector(n, vector(n, INT32_MAX)); 
        
        // fill top row dp 
        for(long i = 0; i < n; i++) { 
            dp[0][i] = matrix[0][i]; 
        }
        
        // dp 
        for(long i = 0; i < n-1; i++) { 
            // deal with corners 
            dp[i+1][0] = min(dp[i+1][0], dp[i][0]+matrix[i+1][0]); 
            dp[i+1][1] = min(dp[i+1][1], dp[i][0]+matrix[i+1][1]); 
            
            // main case 
            for(long j = 1; j < n-1; j++) { // corners are edge cases 
                dp[i+1][j-1] = min(dp[i+1][j-1], dp[i][j]+matrix[i+1][j-1]); 
                dp[i+1][j] = min(dp[i+1][j], dp[i][j]+matrix[i+1][j]); 
                dp[i+1][j+1] = min(dp[i+1][j+1], dp[i][j]+matrix[i+1][j+1]); 
            }
            
            // edge case 
            dp[i+1][n-2] = min(dp[i+1][n-2], dp[i][n-1]+matrix[i+1][n-2]); 
            dp[i+1][n-1] = min(dp[i+1][n-1], dp[i][n-1]+matrix[i+1][n-1]);
        }
        
        // find answer 
        int ret = INT32_MAX; 
        for(long i = 0; i < n; i++) {
            ret = min(ret, dp[n-1][i]);
        }
        return ret; 
    }
};
