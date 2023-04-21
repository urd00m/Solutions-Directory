#define MOD 1000000007

class Solution {
public:
    int profitableSchemes(int n, int minProfit, vector<int>& group, vector<int>& profit) {
        // dp[i][j] -- i is the group members used and j is the profit obtained 
        // n * minProfit 
        vector<vector<int>> dp = vector(n+1, vector(minProfit+1, 0)); 
        dp[0][0] = 1; 

        // iterate through each crime and update 
        for(int idx = 0; idx < group.size(); idx++) {
            int ppl_needed = group[idx];
            int p = profit[idx]; 

            // update dp table 
            for(int i = n; i >= 0; i--) {
                if(i+ppl_needed > n) continue; // can't do this job too many people needed
                for(int j = 0; j <= minProfit; j++) {
                    dp[i+ppl_needed][min(minProfit, j + p)] = (dp[i+ppl_needed][min(minProfit, j + p)] + dp[i][j])%MOD;
                }
            }
        }

        int ret = 0; 
        for(int i = 0; i <= n; i++) ret = (ret + dp[i][minProfit])%MOD;
        return ret; 
    }
};
