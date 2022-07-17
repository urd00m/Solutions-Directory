#define MOD 1000000007
class Solution {
public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // bfs with dp? 
        if(maxMove == 0) return 0; 
        vector<vector<vector<int>>> dp = vector(m, vector(n, vector(maxMove+1, 0)));
        dp[startRow][startColumn][0] = 1; 
        queue<vector<int>> q; // (vector of size 2, r, c, depth)
        q.push({startRow, startColumn, 0}); 
        
        // dp with queue
        long ret = 0; 
        while(!q.empty()) {
            vector<int> cur = q.front(); q.pop(); // get top 
            int r = cur[0];
            int c = cur[1]; 
            int depth = cur[2]; 
            if(depth == maxMove) break; // all the ones after it are also out of moves   
            // if we go out of bounds 
            if(r+1 >= m) ret = (ret+dp[r][c][depth])%MOD; 
            if(r-1 < 0) ret = (ret+dp[r][c][depth])%MOD; 
            if(c-1 < 0) ret = (ret+dp[r][c][depth])%MOD; 
            if(c+1 >= n) ret = (ret+dp[r][c][depth])%MOD;  
            
            // update 
            if(r+1 < m) {
                if(dp[r+1][c][depth+1] == 0) q.push({r+1, c, depth+1}); 
                dp[r+1][c][depth+1] = (dp[r+1][c][depth+1]+dp[r][c][depth])%MOD; 
            }
            if(r-1 >= 0) {
                if(dp[r-1][c][depth+1] == 0) q.push({r-1, c, depth+1});
                dp[r-1][c][depth+1] = (dp[r-1][c][depth+1]+dp[r][c][depth])%MOD; 
            }
            if(c+1 < n) {
                if(dp[r][c+1][depth+1] == 0) q.push({r, c+1, depth+1}); 
                dp[r][c+1][depth+1] = (dp[r][c+1][depth+1]+dp[r][c][depth])%MOD; 
            }
            if(c-1 >= 0) {
                if(dp[r][c-1][depth+1] == 0) q.push({r, c-1, depth+1});
                dp[r][c-1][depth+1] = (dp[r][c-1][depth+1]+dp[r][c][depth])%MOD; 
            }
        }
        
        return ret; 
        
    }
};
