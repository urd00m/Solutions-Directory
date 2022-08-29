class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        // flood fill 
        int ret = 0; 
        
        // check everything 
        for(long i = 0; i < grid.size(); i++) {
            for(long j = 0; j < grid[0].size(); j++) {
                if(grid[i][j] == '1') {
                    ret++; 
                    flood(grid, i, j); 
                }
            }
        }
        
        return ret; 
    }
    
    
    void flood(vector<vector<char>>& grid, int curRow, int curCol) {
        //bounds check 
        if(curRow < 0 || curRow >= grid.size() || curCol < 0 || curCol >= grid[0].size()) return; 
        
        if(grid[curRow][curCol] == '2' || grid[curRow][curCol] == '0') return; //already visited 
        grid[curRow][curCol] = '2'; //marked visited 
        
        // check adj 
        flood(grid, curRow, curCol-1);
        flood(grid, curRow, curCol+1);
        flood(grid, curRow-1, curCol);
        flood(grid, curRow+1, curCol);
    }
};
