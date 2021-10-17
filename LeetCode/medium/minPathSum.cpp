class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        //bfs going left and right record minimums 
        queue<pair<int, int>> next; 
        next.push(make_pair(0, 0)); //add 0 
        vector<vector<int>> dp(grid.size(), vector<int>(grid[0].size(), INT32_MAX));
        vector<vector<int>> visited(grid.size(), vector<int>(grid[0].size(), 0));
        dp[0][0] = grid[0][0]; //itself  
        long n = grid.size(); long m = grid[0].size(); 
        while(next.empty() == false) {
            pair cur = next.front(); next.pop(); //we will end up double counting 
            long row = cur.first; long col = cur.second; 
            
            if(visited[row][col] == 1) continue; 
            
            //check down
            if(row+1 < n) {
                dp[row+1][col] = min(dp[row][col] + grid[row+1][col], dp[row+1][col]); 
                next.push(make_pair(row+1, col)); 
            }
            
            //check right
            if(col+1 < m) {
                dp[row][col+1] = min(dp[row][col] + grid[row][col+1], dp[row][col+1]); 
                next.push(make_pair(row, col+1)); 
            }
            
            visited[row][col] = 1; 
        }
        
        return dp[n-1][m-1]; 
    }
};
