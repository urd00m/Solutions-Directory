#define BUYING 0
#define SELLING 1
#define MIN -1000000000
class Solution {
public:
    int maxProfit(int num_t, vector<int>& prices) {
        // states n by num_t by 2, n for each price, num_t for transactions remaining, and 2 for either currently have to sell have to buy 
        // transition O(1) 
        // for i j       dp[i][j][SELLING] = max(dp[i-1][j+1][BUYING] - price[i-1], dp[i-1][j][SELLING])
        //               dp[i][j][BUYING] = max(dp[i-1][j][BUYING], dp[i-1][j][SELLING] + price[i-1]) 
        long n = prices.size();  
        vector<vector<vector<int>>> dp = vector(n+1, vector(num_t+2, vector(2, MIN))); 
        dp[0][num_t][BUYING] = 0; // init 
        int ret = MIN;
        for(int i = 1; i <= n; i++) { // iterate through all prices 
            for(int j = num_t; j >= 0; j--) {
                dp[i][j][SELLING] = max(dp[i-1][j+1][BUYING] - prices[i-1], dp[i-1][j][SELLING]);
                dp[i][j][BUYING] = max(dp[i-1][j][BUYING], dp[i-1][j][SELLING] + prices[i-1]); 
                ret = max(ret,dp[i][j][BUYING]); 
            }
        }
        
        return ret != MIN ? ret : 0; 
    }
};
