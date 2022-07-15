class Solution {
public:
    vector<vector<int>> visited;
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int ret = INT32_MIN;
        visited = vector(grid.size(), vector(grid[0].size(), 0));
        for(long i = 0; i < grid.size(); i++) {
            for(long j = 0; j < grid[0].size(); j++) {
                ret = max(ret, flood(grid, i, j)); 
            }
        }
        
        return ret; 
    }
    
    // flood fill 
    int flood(vector<vector<int>>& grid, int r, int c) {
        if(r < 0 || r >= grid.size() || c < 0 || c >= grid[0].size() || visited[r][c] == 1 || grid[r][c] == 0) return 0; 
        visited[r][c] = 1; 
        return 1 + flood(grid, r+1, c) + flood(grid, r-1, c) + flood(grid, r, c+1) + flood(grid, r, c-1); 
    }
};
