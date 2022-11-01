class Solution {
public:
    
    int ans(vector<vector<int>>& grid, int col, int depth) {
        if(depth == grid.size()) return col; 
        if(col + grid[depth][col] < 0 || col + grid[depth][col] >= grid[0].size()) return -1; // stuck on wall 
        if(abs(grid[depth][col] + grid[depth][col + grid[depth][col]]) == 2) 
            return (ans(grid, col + grid[depth][col + grid[depth][col]], depth+1)); 
        return -1; 
    }
    
    vector<int> findBall(vector<vector<int>>& grid) {
        // DFS or each 
        // if the abs(grid[i][j] + grid[i][j + grid[i][j]]) != 2 it get stuck 
        vector<int> ret; 
        for(int i = 0; i < grid[0].size(); i++) 
            ret.push_back(ans(grid, i, 0)); 
        return ret; 
    }
};
