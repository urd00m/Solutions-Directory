class Solution {
public:
    
    int matrix_sum(vector<vector<int>>& dp, int lr, int lc, int rr, int rc) {
        return dp[rr][rc] - dp[rr][lc-1] - dp[lr-1][rc] + dp[lr-1][lc-1];
    }
    
    int maximalRectangle(vector<vector<char>>& matrix) {
        // prefix matrix calculation, determine rectangle in O(1) 
        long n = matrix.size(); long m = matrix[0].size();
        vector<vector<int>> dp = vector(n+1, vector(m+1, 0)); // 1 index 
        for(int i = 1; i < n+1; i++) 
            for(int j = 1; j < m+1; j++) 
                dp[i][j] = (matrix[i-1][j-1]-'0') + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]; 

        // brute force attempt O(n^3) 
        int ret = 0; 
        for(int i = 1; i < n+1; i++) { //left corner
            for(int j = 1; j < m+1; j++) {
                for(int j2 = j; j2 < m+1; j2++) { //right corner col 
                    int height = 1; 
                    while(i+height-1 < n+1 && (j2-j+1)*(height) == matrix_sum(dp, i, j, i+height-1, j2)) {
                        ret = max(ret, (j2-j+1)*(height++)); 
                    }
                    if(ret == n*m) return ret; 
                }
            }
        }
        
        
        return ret;    
    }
};
