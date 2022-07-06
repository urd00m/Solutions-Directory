class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        vector<int> dp = vector(10003, 0); 
        vector<int> totals = vector(10003, 0); 
        
        // sum up totals 
        for(int item : nums)
            totals[item] += item; 
        
        // dp 
        for(long i = 1; i < 10001; i++) {
            dp[i+2] = max(dp[i+2], dp[i] + totals[i]); // take it
            dp[i+1] = max(dp[i+1], dp[i]);  // skip it 
        }
        
        return max(dp[10001], dp[10002]); 
    }
};
