class Solution {
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        // dp 
        int n = heights.size(); int m = heights[0].size(); 
        
        // 1 by 1
        if(n == 1 && m == 1) return {{0,0}}; 
        
        // setup dp 
        vector<vector<int>> dp = vector(n, vector(m, 0)); 
        vector<vector<bool>> visited = vector(n, vector(m, false)); 
        queue<vector<int>> next; 
        
        // dp 
        // encoding pacific = 01b alantic = 10b
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 1; j++) {
                visited = vector(n, vector(m, false)); 
                next.push({i, j}); 
                visited[i][j] = true; 

                while(!next.empty()) {
                    vector<int> cur = next.front(); next.pop(); 
                    int r = cur[0]; int c = cur[1]; 

                    // bordering pacific ocean or altantic ocean 
                    if(r == 0 || c == 0) dp[r][c] |= 1; 
                    if(r == n-1 || c == m-1) dp[r][c] |= 2; 

                    // look 4 directions and update 
                    if(r > 0) {
                        if(heights[r-1][c] >= heights[r][c]) dp[r-1][c] |= dp[r][c]; 
                        if(!visited[r-1][c]) {
                            visited[r-1][c] = true; 
                            next.push({r-1, c}); 
                        }
                    }
                    if(r < n-1) {
                        if(heights[r+1][c] >= heights[r][c]) dp[r+1][c] |= dp[r][c]; 
                        if(!visited[r+1][c]) {
                            visited[r+1][c] = true; 
                            next.push({r+1, c}); 
                        }
                    }
                    if(c > 0) {
                        if(heights[r][c-1] >= heights[r][c]) dp[r][c-1] |= dp[r][c]; 
                        if(!visited[r][c-1]) {
                            visited[r][c-1] = true; 
                            next.push({r, c-1}); 
                        }
                    }
                    if(c < m-1) {
                        if(heights[r][c+1] >= heights[r][c]) dp[r][c+1] |= dp[r][c]; 
                        if(!visited[r][c+1]) {
                            visited[r][c+1] = true; 
                            next.push({r, c+1}); 
                        }
                    }
                }
            }
        }
        
        /*
        for(int i = 0; i < 1; i++) {
            for(int j = 0; j < m; j++) {
                visited = vector(n, vector(m, false)); 
                next.push({i, j}); 
                visited[i][j] = true; 

                while(!next.empty()) {
                    vector<int> cur = next.front(); next.pop(); 
                    int r = cur[0]; int c = cur[1]; 

                    // bordering pacific ocean or altantic ocean 
                    if(r == 0 || c == 0) dp[r][c] |= 1; 
                    if(r == n-1 || c == m-1) dp[r][c] |= 2; 

                    // look 4 directions and update 
                    if(r > 0) {
                        if(heights[r-1][c] >= heights[r][c]) dp[r-1][c] |= dp[r][c]; 
                        if(!visited[r-1][c]) {
                            visited[r-1][c] = true; 
                            next.push({r-1, c}); 
                        }
                    }
                    if(r < n-1) {
                        if(heights[r+1][c] >= heights[r][c]) dp[r+1][c] |= dp[r][c]; 
                        if(!visited[r+1][c]) {
                            visited[r+1][c] = true; 
                            next.push({r+1, c}); 
                        }
                    }
                    if(c > 0) {
                        if(heights[r][c-1] >= heights[r][c]) dp[r][c-1] |= dp[r][c]; 
                        if(!visited[r][c-1]) {
                            visited[r][c-1] = true; 
                            next.push({r, c-1}); 
                        }
                    }
                    if(c < m-1) {
                        if(heights[r][c+1] >= heights[r][c]) dp[r][c+1] |= dp[r][c]; 
                        if(!visited[r][c+1]) {
                            visited[r][c+1] = true; 
                            next.push({r, c+1}); 
                        }
                    }
                }
            }
        }
        */
        
        // count 3s 
        vector<vector<int>> ret; 
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < m; j++) 
                if(dp[i][j] == 3) ret.push_back({i, j}); 

        return ret;  
        
    }
};
