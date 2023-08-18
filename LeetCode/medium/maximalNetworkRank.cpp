class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        // calculate in degree + maintain adj matrix
        vector<vector<int>> mat = vector(n, vector(n, 0)); 
        vector<int> indeg = vector(n, 0); 
        for(vector<int>& r : roads) {
            mat[r[0]][r[1]] = 1; 
            mat[r[1]][r[0]] = 1; 
            indeg[r[0]]++;
            indeg[r[1]]++; 
        }

        // find max
        int ret = 0; 
        for(int i = 0; i < n; i++) 
            for(int j = i+1; j < n; j++)
                ret = max(ret, indeg[i] + indeg[j] - mat[i][j]);
        return ret; 
    }
};
