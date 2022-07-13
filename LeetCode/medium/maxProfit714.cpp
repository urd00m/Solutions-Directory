class Solution {
public:
    int maxProfit(vector<int>& prices) {
        vector<vector<int>> dp = vector(prices.size(), vector(2, -1)); 
        return dfs(dp, prices, 0, 1); 
    }
    
    int dfs(vector<vector<int>>& dp, vector<int>& prices, int cur, int buy) {
        if(cur >= prices.size()) return 0; 
        
        if(dp[cur][buy] != -1) return dp[cur][buy]; 
        
        // two cases, can buy or can't 
        if(buy) { // can buy 
            dp[cur][buy] = max((-1*prices[cur])+dfs(dp, prices, cur+1, 0), dfs(dp, prices, cur+1, 1)); // either we buy or we don't 
        }
        else { // can't buy (selling)
            dp[cur][buy] = max(prices[cur]+dfs(dp, prices, cur+2, 1), dfs(dp, prices, cur+1, 0)); // sell or don't sell 
        }
        return dp[cur][buy]; 
    }
};
