class Solution {
public:
    int combinationSum4(vector<int>& nums, int target) {
        vector<long> dp = vector(target+1, 0L); 
        dp[0] = 1; 
        
        // butterfly dp 
        for(long i = 0; i < target; i++) {
            if(dp[i] >= INT32_MAX) continue; 
            for(int num : nums) {
                if(i+num <= target) dp[i+num] += dp[i]; 
            }
        }
        
        return dp[target]; 
    }
};
