class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        //caluculate total 
        int total = 0;
        long startR = -1, startC = -1; 
        long endR = -1, endC = -1; 
        for(long i = 0; i < grid.size(); i++) {
            for(long j = 0; j < grid[0].size(); j++) {
                if(grid[i][j] == 0) total++;
                else if(grid[i][j] == 1) {
                    startR = i; 
                    startC = j; 
                }
                else if(grid[i][j] == 2) {
                    endR = i; 
                    endC = j;
                }
            }
        }
        vector<vector<bool>> visited(grid.size(), vector(grid[0].size(), false));
        return recur(startR, startC, visited, grid, total+1); //including the start node
    }
    int recur(long row, long col, vector<vector<bool>>& visited, vector<vector<int>>& grid, int total) {
        //bounds check 
        if(row < 0 || row >= grid.size()) return 0;
        if(col < 0 || col >= grid[0].size()) return 0;
        if(grid[row][col] == -1) return 0;
        
        //base case 
        if(visited[row][col] == true) return 0; //already visited 
        if(total == 0 && grid[row][col] == 2) return 1; 
        if(total == 0 && grid[row][col] != 2) return 0; 
        
        //iteration
        total--; //visited a node 
        visited[row][col] = true; 
        int ret = recur(row-1, col, visited, grid, total) + recur(row+1, col, visited, grid, total) + recur(row, col-1, visited, grid, total) + recur(row, col+1, visited, grid, total);
        visited[row][col] = false; 
        return ret;
    }
};
