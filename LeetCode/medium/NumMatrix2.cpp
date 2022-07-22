class NumMatrix {
public:
    vector<vector<int>> dp; 
    long n;
    long m; 
    NumMatrix(vector<vector<int>>& matrix) {
        // matrix prefix 
        n = matrix.size(); m = matrix[0].size(); 
        dp = vector(n+1, vector(m+1, 0)); // one index 
        
        // fill dp 
        for(long i = 1; i < n+1; i++) {
            for(long j = 1; j < m+1; j++) {
                dp[i][j] = matrix[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1]; 
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */
