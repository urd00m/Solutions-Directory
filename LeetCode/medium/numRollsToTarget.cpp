#define MOD 1000000007
class Solution {
public:
    int numRollsToTarget(int n, int k, int target) {
        if(n > target) return 0; 
        else if(n*k < target) return 0; 
        
        // dp 
        vector<vector<int>> dp = vector(n+1, vector(target+1, 0)); 
        dp[0][0] = 1; 
        
        for(int i = 0; i < n; i++) 
            for(int curSum = 0; curSum < target; curSum++) 
                for(int face = 1; face <= k; face++) 
                    if(curSum + face <= target) dp[i+1][curSum+face] = (dp[i+1][curSum+face]+dp[i][curSum])%MOD; 

        return dp[n][target]; 
    }
};
