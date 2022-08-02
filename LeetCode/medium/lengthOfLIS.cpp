class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        // dp 
        // O(n) state, find the max up to the point i 
        // O(n) update (unoptimized) search through 0 ... i-1 and if nums[j] < nums[i] we add 1 to dp[i] = dp[j]+1
        // O(log n) update (optimized) 
        long n = nums.size(); 
        vector<int> dp = vector(n, 1); 
        dp[0] = 1; 
        for(long i = 1; i < n; i++) {
            // build off previous or start a new one 
            for(long j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = max(dp[i], dp[j]+1); 
            }
        }
        int ret = 0; 
        for(int item : dp) ret = max(ret, item);
        return ret;
    }
};
