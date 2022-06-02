class Solution {
public:
    vector<vector<int>> transpose(vector<vector<int>>& matrix) {
        vector<vector<int>> ret = vector(matrix[0].size(), vector(matrix.size(), 0));
        for(long i = 0; i < matrix.size(); i++) {
            for(long j = 0; j < matrix[0].size(); j++) {
                ret[j][i] = matrix[i][j];
            }
        }
        return ret; 
    }
};
