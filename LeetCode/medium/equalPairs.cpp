class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
        // brute force O(n^3) is acceptable 
        int ret = 0; 
        size_t n = grid.size(); 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                bool match = true; 
                for(int k = 0; k < n; k++) {
                    if(grid[i][k] != grid[k][j]) {
                        match = false;
                        break; 
                    }
                }
                if(match) ret++; 
            }
        }
        return ret; 
    }
};
