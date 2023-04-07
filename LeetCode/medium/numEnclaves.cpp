#define MIN -10000000
class Solution {
public:
    int numEnclaves(vector<vector<int>>& grid) {
        // flood fill return 1 if it doesn't exit on the edge 0 otherwise 
        size_t n = grid.size(), m = grid[0].size(); 
        vector<vector<int>> visited = vector(n, vector(m, 0)); 
        int ret = 0; 
        for(size_t i = 0; i < n; i++) {
            for(size_t j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    int res = flood(grid, visited, i, j); 
                    if(res > 0) ret += res; 
                }
            }
        }
        return ret; 
    }

    int flood(vector<vector<int>>& grid, vector<vector<int>>& visited, int curRow, int curCol) {
        size_t n = grid.size(), m = grid[0].size(); 
        if(curRow < 0 || curRow >= n) return 0; 
        if(curCol < 0 || curCol >= m) return 0; 
        if(grid[curRow][curCol] == 0 || visited[curRow][curCol]) return 0; 
        visited[curRow][curCol] = 1; 

        int ret = 1; 
        if(curRow == 0 || curRow == n-1 || curCol == 0 || curCol == m-1) ret = MIN; 
        ret = ret + flood(grid, visited, curRow-1, curCol); 
        ret = ret + flood(grid, visited, curRow+1, curCol); 
        ret = ret + flood(grid, visited, curRow, curCol-1); 
        ret = ret + flood(grid, visited, curRow, curCol+1); 
        return ret; 
    }
};
