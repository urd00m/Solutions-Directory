class Solution {
public:
    int climbStairs(int n) {
        //dp solution butterfly
        vector<int> dp(n+1, 0); 
        dp[0] = 1; 
        for(int i = 0; i <= n; i++) {
            for(int num = 1; num <= 2; num++) {
                if(i + num <= n) {
                    dp[i+num] += dp[i];
                }
            }
        }
        return dp[n]; 
    }
};
