#define MAX 10000
class Solution {
public:
    int fillCups(vector<int>& amount) {
        //dp 
        vector<vector<vector<int>>> dp = vector(101, vector(101, vector(101, MAX)));
        
        // do dp
        return dfs(dp, amount[0], amount[1], amount[2]); 
    }
    
    int dfs(vector<vector<vector<int>>>& dp, int a, int b, int c) {
        if(a == 0 && b == 0 && c == 0) return 0; 
        if(a < 0 || b < 0 || c < 0) return MAX; // out of bounds 
        
        if(dp[a][b][c] != MAX) return dp[a][b][c]; 
        
        int ret = MAX;
        ret = min(ret, dfs(dp, a-1, b-1, c)+1);
        ret = min(ret, dfs(dp, a, b-1, c-1)+1);
        ret = min(ret, dfs(dp, a-1, b, c-1)+1);
        if(ret == MAX) {
            ret = min(ret, dfs(dp, a-1, b, c)+1);
            ret = min(ret, dfs(dp, a, b-1, c)+1);
            ret = min(ret, dfs(dp, a, b, c-1)+1);
        }
        return dp[a][b][c] = ret; 
    }
};
