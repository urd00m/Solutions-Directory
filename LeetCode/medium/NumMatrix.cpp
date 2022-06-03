/* This one is ~75-100 ms faster for some reason. I suspect due to its forward nature it has better cache performance somehow 
class NumMatrix {
public:
    vector<vector<int>> mat;
    NumMatrix(vector<vector<int>>& matrix) {
        int m = matrix.size(),n = matrix[0].size();
        mat = vector<vector<int>>(m+1,vector<int>(n+1,0));
        for(int i = 1 ; i <= m; i++){
            for(int j = 1; j <= n; j++){
                    mat[i][j] = matrix[i-1][j-1] + mat[i-1][j] + mat[i][j-1] - mat[i-1][j-1];
            }
        }
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        return mat[row2+1][col2+1] - mat[row1][col2 + 1] - mat[row2 + 1][col1] + mat[row1][col1];
    }
};
*/
class NumMatrix {
public:
    vector<vector<int>> dp; 
    NumMatrix(vector<vector<int>>& matrix) {
        // dp   
        dp = vector(matrix.size()+1, vector(matrix[0].size()+1, 0)); 
        for(long i = matrix.size()-1; i >= 0; i--) {
            for(long j = matrix[0].size()-1; j >= 0; j--) {
               dp[i][j] = matrix[i][j] + dp[i+1][j] + dp[i][j+1] - dp[i+1][j+1]; 
            }
        }
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        // O(1) searches 
        return dp[row1][col1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row2+1][col2+1]; 
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */
