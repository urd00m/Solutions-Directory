class Solution {
public:
    // 2 6 0 4
    // 0 0 -12 -48
    // 0 0
    // -2 0 -1
    
    // 2 0  20 8 24
    // 0 -10 -2 -80 -240
    int maxProduct(vector<int>& nums) {
        if(nums.size() == 1) return nums[0]; 
        
        // 2 x n (pos 0th idx and neg 1th idx, axis=0) 
        vector<vector<int>> dp = vector(2, vector(nums.size(), 0)); 
        // fill init 
        if(nums[0] > 0) dp[0][0] = nums[0];
        else dp[1][0] = nums[0]; 
        
        // dp 
        for(long i = 1; i < nums.size(); i++) {
            // if nums[i] is positive 
            if(nums[i] > 0) {
                // take or leave 
                dp[0][i] = max(dp[0][i-1]*nums[i], nums[i]);
                dp[1][i] = dp[1][i-1]*nums[i]; 
            }
            
            // if nums[i] is negative 
            if(nums[i] < 0) {
                dp[0][i] = dp[1][i-1]*nums[i];
                dp[1][i] = min(nums[i], dp[0][i-1]*nums[i]); 
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
