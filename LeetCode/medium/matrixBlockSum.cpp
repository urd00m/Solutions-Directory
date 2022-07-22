class Solution {
public:
    vector<vector<int>> matrixBlockSum(vector<vector<int>>& mat, int k) {
        // O(N*M*k^2) just add it as you go 
        long n = mat.size(); long m = mat[0].size(); 
        vector<vector<int>> ret = vector(n, vector(m, 0)); 
        for(long i = 0; i < n; i++) {
            for(long j = 0; j < m; j++) {
                // k 
                for(long i2 = max(0L, i-k); i2 <= min(n-1, i+k); i2++) {
                    for(long j2 = max(0L, j-k); j2 <= min(m-1, j+k); j2++) {
                        ret[i2][j2] += mat[i][j]; 
                    }
                }
            }
        }
        return ret; 
    }
};
