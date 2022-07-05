class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        // butterfly but use min 
        vector<int> dp = vector(cost.size()+1, INT32_MAX)f;
        dp[0] = 0; 
        dp[1] = 0; 
        for(int i = 0; i <= cost.size(); i++) {
            // take 1 or 2 steps 
            if(i+2 <= cost.size()) dp[i+2] = min(dp[i+2], dp[i] + cost[i]);
            if(i+1 <= cost.size()) dp[i+1] = min(dp[i+1], dp[i] + cost[i]);
        }
        
        return dp[cost.size()]; 
    }
};
