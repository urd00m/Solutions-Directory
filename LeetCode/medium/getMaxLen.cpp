class Solution {
public:
    // 1 0 3 4
    // 0 2 1 2
    int getMaxLen(vector<int>& nums) {
        if(nums.size() == 1) return nums[0] > 0 ? 1 : 0; 
        
        // 2 x n (pos 0th idx and neg 1th idx, axis=0) 
        vector<vector<int>> dp = vector(2, vector(nums.size(), 0)); 
        // fill init 
        if(nums[0] > 0) dp[0][0] = 1;
        else if(nums[0] < 0) dp[1][0] = 1; 
        
        // dp 
        for(long i = 1; i < nums.size(); i++) {
            if(nums[i] == 0) continue; //skip zeros 
            
            // if nums[i] is positive 
            if(nums[i] > 0) {
                // take or leave 
                dp[0][i] = dp[0][i-1]+1;
                if(dp[1][i-1] != 0) dp[1][i] = dp[1][i-1]+1; 
            }
            
            // if nums[i] is negative 
            if(nums[i] < 0) {
                if(dp[1][i-1] != 0) dp[0][i] = dp[1][i-1]+1;
                dp[1][i] = dp[0][i-1]+1; 
            }            
        }
        
        // find max 
        int ret = 0; 
        for(int item : dp[0]) 
            //cout << item << endl; 
            ret = max(ret, item); 
        return ret; 
    }
};
