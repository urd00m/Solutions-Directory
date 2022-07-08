class Solution {
public:
    int minCost(vector<int>& houses, vector<vector<int>>& cost, int m, int n, int target) {
        // dp 
        // ith house, painted with jth color, kth color 
        vector<vector<vector<int>>> dp = vector(m, vector(n+1, vector(target+2, -1))); //target + 2 to avoid overflow (index target+1 is a dummy spot)
        
        // init
        if(houses[0] != 0) dp[0][houses[0]][1] = 0;
        else 
            for(int j = 1; j <= n; j++) 
                dp[0][j][1] = cost[0][j-1]; 
        
        // dp 
        for(int i = 1; i < m; i++) {
            //house has set color (We don't need to worry about cost)
            if(houses[i] != 0) {
                //check previous arrangements
                for(int j = 1; j <= n; j++) {
                    for(int k = 1; k <= target; k++) {
                        if(j == houses[i] && dp[i-1][j][k] != -1)  // previous house matches this color and valid (!= -1)
                            dp[i][houses[i]][k] = (dp[i][houses[i]][k] == -1) ? dp[i-1][j][k] : min(dp[i-1][j][k], dp[i][houses[i]][k]); // if current setup is not defined, or else take min 
                        else if(dp[i-1][j][k] != -1) // doesn't match this color 
                            dp[i][houses[i]][k+1] = (dp[i][houses[i]][k+1] == -1) ? dp[i-1][j][k] : min(dp[i-1][j][k], dp[i][houses[i]][k+1]); // neighbor hood increases 
                    }
                }
            } 
            else { // doesn't have set color (== 0) 
                for(int j = 1; j <= n; j++) {
                    for(int k = 1; k <= target; k++) {
                        // try to color it everything possible 2 cases - match previous or don't match previous 
                        for(int j2 = 1; j2 <= n; j2++) {
                            int cost_to_color = cost[i][j2-1];  //cost to color current house
                            if(j2 == j && dp[i-1][j][k] != -1) // match previous color 
                                dp[i][j2][k] = (dp[i][j2][k] == -1) ? dp[i-1][j][k]+cost_to_color : min(dp[i-1][j][k]+cost_to_color, dp[i][j2][k]);
                            else if(dp[i-1][j][k] != -1) // no match 
                                dp[i][j2][k+1] = (dp[i][j2][k+1] == -1) ? dp[i-1][j][k]+cost_to_color : min(dp[i-1][j][k]+cost_to_color, dp[i][j2][k+1]);
                        }
                    }
                }
            }
        }
        
        // collect result (all possible j's that reach k target at house m-1)
        int ret = INT32_MAX;
        for(int j = 1; j <= n; j++)
            ret = min(ret, dp[m-1][j][target] == -1 ? INT32_MAX : dp[m-1][j][target]);
        return (ret == INT32_MAX) ? -1 : ret; 
    }
};

// slower due to if statements, you can probably get rid of the if statement flow but it is a little rushed 
