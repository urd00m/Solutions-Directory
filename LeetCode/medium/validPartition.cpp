class Solution {
public:
    bool validPartition(vector<int>& nums) {
        // either partition or not partition 
        // state 0 -> n-1 
        // good partition 1 bad -> 0
        size_t n = nums.size();
        vector<int> dp = vector(n, 0); // 0 index 
        for(int i = 0; i < n; i++) {
            if(i+1 < n && nums[i] == nums[i+1]) {
                if(i-1 < 0) dp[i+1] = 1; 
                else dp[i+1] |= dp[i-1]; 
            }
            if(i+1 < n && i+2 < n && nums[i] == nums[i+1] && nums[i] == nums[i+2]) {
                if(i-1 < 0) dp[i+2] = 1; 
                else dp[i+2] |= dp[i-1]; 
            }
            if(i+1 < n && i+2 < n && nums[i+1] - nums[i] == 1 && nums[i+2] - nums[i+1] == 1) {
                if(i-1 < 0) dp[i+2] = 1; 
                else dp[i+2] |= dp[i-1];
            }
        }
        return dp[n-1];
    }
};
