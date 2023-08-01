class Solution {
public:
    int maxProfit(vector<int>& prices) {
        // 2D DP (max profit)
        // 3xn 
        // state i,j: ith transaction, jth node (stores max profit at that step, exclusive) best seen so far 
        // trick is dp update to bring time complex to O(n) 
        // instead of just looking at prices you want to select the minimum cost value -> i.e. the cost of buying the at that ith price and also getting the amount earned from the previous kth iteration 
        size_t n = prices.size(); 
        vector<vector<int>> dp = vector(3, vector(n, 0)); 

        // kth iterations
        // update: price[i] + dp[k-1][prev - 1] - price[prev]; 
        for(int k = 1; k < 3; k++) {
            int m = -1 * prices[0]; 
            for(int i = 1; i < n; i++) {
                m = max(m, dp[k-1][i-1] - prices[i]);
                dp[k][i] = max(dp[k][i-1], prices[i] + m); 
            }
        }
        return dp[2][n-1]; 
    }
};
