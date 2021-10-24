class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        long n = matrix.size(); 
        long m = matrix[0].size(); 
        vector<vector<int>> ret(n, vector(m, -1)); 
        
        for(long i = 0; i < n; i++) {
            for(long j = 0; j < m; j++) {
                if(ret[i][j] != 0 && matrix[i][j] != 0) ret[i][j] = matrix[i][j];
                else if (matrix[i][j] == 0) { 
                    //Set column and and rows to zero 
                    for(long row = 0; row < n; row++) {
                        ret[row][j] = 0;
                    }
                    for(long col = 0; col < m; col++) {
                        ret[i][col] = 0; 
                    }
                }
            }
        }
        
        for(long i = 0; i < n; i++) {
            for(long j = 0; j < m; j++) {
                matrix[i][j] = ret[i][j]; 
            }
        }
    }
};
