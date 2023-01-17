#define ZERO 0 
#define ONE 1 

class Solution {
public:
    int minFlipsMonoIncr(string s) {
        // dp 
        // state n and 1 or 0 --> 2*n state 
        // dp[i][ZERO] = dp[i-1][ZERO] + (s[i] == '0' ? 0 : 1) 
        // dp[i][ONE] = min(dp[i-1][ZERO], dp[i-1][ONE]) + (s[i] == '1' ? 0 : 1))
        long n = s.size();
        vector<vector<int>> dp = vector(n+1, vector(2, INT32_MAX)); // 1 index 
        dp[0][ZERO] = 0; dp[0][ONE] = 0; 

        // dp 
        for(int i = 1; i < n+1; i++) {
            dp[i][ZERO] = dp[i-1][ZERO] + (s[i-1] == '0' ? 0 : 1); 
            dp[i][ONE] = min(dp[i-1][ZERO], dp[i-1][ONE]) + (s[i-1] == '1' ? 0 : 1);
        }   

        return min(dp[n][ZERO], dp[n][ONE]);
    }
};
