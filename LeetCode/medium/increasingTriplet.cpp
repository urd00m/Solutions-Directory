#define INIT -1283231
class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        long n = nums.size(); 
        if(n < 3) return false; 
        
        // dp 3 by n state 
        vector<vector<int>> dp = vector(2, vector(n+1, INIT)); 
        
        // state update rules 
        // you can replace the 0th index with the minimum found 
        // you can replace the 1th index when you with the minimum items found greater than the minimum found 
        // if you find an item greater than the 1th index you are done 
        dp[0][0] = nums[0]; 
        for(int i = 1; i < n; i++) {
            // check 0th index
            if(nums[i] < dp[0][i-1]) {
                dp[0][i] = nums[i]; 
                dp[1][i] = dp[1][i-1];
            }
            else if(nums[i] > dp[0][i-1]) {
                dp[0][i] = dp[0][i-1]; 
                dp[1][i] = min(dp[1][i-1] == INIT ? INT32_MAX : dp[1][i-1], nums[i]); 
            }
            else {
                dp[0][i] = dp[0][i-1]; 
                dp[1][i] = dp[1][i-1];
            }
            
            // check if any pass 
            if(dp[1][i-1] != INIT && nums[i] > dp[1][i-1]) return true; 
        }
        
        return false; 
    }
};
