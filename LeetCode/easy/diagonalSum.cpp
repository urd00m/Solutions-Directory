class Solution {
public:
    int diagonalSum(vector<vector<int>>& mat) {
        size_t n = mat.size(); 
        int ret = 0;
        for(int i = 0; i < n; i++) {
            ret += mat[i][i]; 
            ret += mat[i][n-i-1];
        }
        if(n%2) ret -= mat[n/2][n-n/2-1]; 
        return ret; 
    }
};
