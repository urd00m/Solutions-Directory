class Solution {
public:
    vector<vector<vector<int>>> paint; 
    int shortestPath(vector<vector<int>>& grid, int k) {
        vector<vector<vector<int>>> dp(grid.size(), vector<vector<int>>(grid[0].size(), vector<int>(k+1, INT_MAX))); 
        dp[0][0][0] = 0; 
        for(long depth = 0; depth < k+1; depth++) {
            
            for(long i = 0; i < grid.size(); i++) {
                for(long j = 0; j < grid[0].size(); j++) {
                    //go right (only if you can) 
                    if(dp[i][j][depth] == INT_MAX) continue; 
                    if(j < grid[0].size()-1) {
                        //if there is something blocking
                        if(grid[i][j+1] == 1 && depth < k) {
                            dp[i][j+1][depth+1] = dp[i][j+1][depth+1] < dp[i][j][depth]+1 ? dp[i][j+1][depth+1] : dp[i][j][depth]+1;
                        }
                            
                        //there isn't something blocking
                        else if(grid[i][j+1] == 0) {
                            dp[i][j+1][depth] = dp[i][j+1][depth] < dp[i][j][depth]+1 ? dp[i][j+1][depth] : dp[i][j][depth]+1; 
                        }
                    }
                    
                    //go down (only if you can)
                    if(i < grid.size()-1) {
                        //if there is something blocking
                        if(grid[i+1][j] == 1 && depth < k) {
                            dp[i+1][j][depth+1] = dp[i+1][j][depth+1] < dp[i][j][depth]+1 ? dp[i+1][j][depth+1] : dp[i][j][depth]+1;
                        }
                            
                        //there isn't something blocking
                        else if(grid[i+1][j] == 0) {
                            dp[i+1][j][depth] = dp[i+1][j][depth] < dp[i][j][depth]+1 ? dp[i+1][j][depth] : dp[i][j][depth]+1; 
                        }
                    }
                }
            }
            
        }
        
        for(long i = 0; i < grid.size(); i++) {
            for(long j = 0; j < grid[0].size(); j++) {
                cout << grid[i][j] << " ";
            }
            cout << endl;
        }
        cout << endl;

        //test
        for(long depth = 0; depth < k+1; depth++) {
            for(long i = 0; i < grid.size(); i++) {
                for(long j = 0; j < grid[0].size(); j++) {
                    cout << dp[i][j][depth] << " ";
                }
                cout << endl;
            }
            cout << endl << endl;
        }
        
        // Find min
        int min = INT_MAX; 
        for(long depth = 0; depth < k+1; depth++) {
            min = min < dp[grid.size()-1][grid[0].size()-1][depth] ? min : dp[grid.size()-1][grid[0].size()-1][depth];
        }
        if(min == INT_MAX) return -1; 
        else return min;
    }
};
