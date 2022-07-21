class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        long n = triangle.size(); 
        if(n == 1) return triangle[0][0]; 
        
        vector<vector<int>> dp = vector(n, vector(n, INT32_MAX));
        dp[0][0] = triangle[0][0]; 
        
        for(long i = 0; i < n-1; i++) {
            for(long j = 0; j < i+1; j++) {
                dp[i+1][j] = min(dp[i+1][j], dp[i][j]+triangle[i+1][j]);
                dp[i+1][j+1] = min(dp[i+1][j+1], dp[i][j]+triangle[i+1][j+1]);
            }
        }
        
        // find min 
        int ret = INT32_MAX;
        for(long i = 0; i < n; i++) {
            ret = min(ret, dp[n-1][i]); 
        }
        return ret; 
    }
};
