class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        long n = matrix.size(); long m = matrix[0].size(); 
        /* dp state is the maximum size square up to that point 
        1 0 1 0 0 
        1 0 1 1 1
        1 1 1 1 1
        1 0 0 1 1 
        
        1 0 1 0 0 
        1 0 1 1 1 
        1 1 1 2 2 
        1 0 0 1 2 
        */
        
        // dp (one index) 
        vector<vector<int>> dp = vector(n+1, vector(m+1, 0)); 
        
        // dp algorithm 
        for(long i = 1; i <= n; i++) {
            for(long j = 1; j <= m; j++) {
                if(matrix[i-1][j-1] == '0') dp[i][j] = 0; 
                else dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1])) + 1; 
            }
        }
        
        // find max area 
        int ret = 0; 
        for(long i = 1; i <= n; i++) 
            for(long j = 1; j <= m; j++) 
                ret = max(ret, dp[i][j]); 
        return ret*ret; 
    }
};
