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

/* second attempt in under 3 minutes 
class Solution {
public:
    int climbStairs(int n) {
        // butterfly 
        vector<int> dp = vector(n+1, 0); 
        dp[0] = 1; 
        for(int i = 0; i <= n; i++) { 
            if(i + 2 <= n) dp[i+2] += dp[i]; 
            if(i + 1 <= n) dp[i+1] += dp[i]; 
        }
        
        return dp[n]; 
    }
};
*/
