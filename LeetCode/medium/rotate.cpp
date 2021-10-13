class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        long n = matrix.size();
        long mid = (matrix.size()/2); 
        int j = 0; 
        int i = 0; 
        for(; i < mid;) {
            //4 way swap 
            for(int k = i; k < n-i-1; k++) {
                int t1 = matrix[i][k]; 
                int t2 = matrix[k][n-j-1]; 
                int t3 = matrix[n-i-1][n-1-k]; 
                int t4 = matrix[n-1-k][j]; 
                matrix[i][k] = t4; 
                matrix[k][n-j-1] = t1; 
                matrix[n-i-1][n-1-k] = t2; 
                matrix[n-1-k][j] = t3; 
            }
            
            j++; i++; 
        }
    }
};

