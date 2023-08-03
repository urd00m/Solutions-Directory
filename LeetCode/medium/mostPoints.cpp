class Solution {
public:
    long long mostPoints(vector<vector<int>>& questions) {
        // standard butterfly DP 
        int n = questions.size(); 
        vector<long long> dp = vector<long long>(n+1, 0L); 
        for(int i = 0; i < n; i++) {
            dp[min(n, i+questions[i][1]+1)] = max(dp[min(n, i+questions[i][1]+1)], dp[i] + questions[i][0]); 
            dp[i+1] = max(dp[i+1], dp[i]); 
        }
        return dp[n]; 
    }
};
