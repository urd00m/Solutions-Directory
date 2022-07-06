class Solution {
public:
    int rob(vector<int>& nums) {
        // you can either skip or rob this house 
        vector<int> dp = vector(nums.size()+2, 0); 
        for(long i = 0; i < nums.size(); i++) {
            if(i+2 < nums.size()+2) dp[i+2] = max(dp[i+2], dp[i]+nums[i]); 
            if(i+1 < nums.size()+2) dp[i+1] = max(dp[i+1], dp[i]);
        }
        return max(dp[nums.size()+1], dp[nums.size()]); 
    }
};
