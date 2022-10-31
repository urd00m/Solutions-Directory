class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        size_t m = matrix.size(); size_t n = matrix[0].size();  
        
        // start from cols 
        for(size_t col_off = 0; col_off < n; col_off++) {
            for(size_t i = 1; i < min(m, n - col_off); i++) if(matrix[i-1][i-1 + col_off] != matrix[i][i + col_off]) return false; 
        }
        
        // do remaining rows 
        for(size_t row_off = 1; row_off < m; row_off++) {
            for(size_t i = 1; i < min(m - row_off, n); i++) if(matrix[i-1 + row_off][i-1] != matrix[i + row_off][i]) return false; 
        }
        
        return true; 
    }
};
