#define FIRST_ROBBED 0
#define FIRST_UNROBBED 1

class Solution {
public:
    int rob(vector<int>& nums) {
        // you can either skip or rob this house 
        vector<vector<int>> dp = vector(2, vector(nums.size()+2, 0)); 
        
        // handle first case differently 
        dp[FIRST_ROBBED][2] = nums[0]; // we robbed the first house  
        
        for(long i = 1; i < nums.size(); i++) {
            // first not robbed 
            if(i+2 < nums.size()+2) dp[FIRST_UNROBBED][i+2] = max(dp[FIRST_UNROBBED][i+2], dp[FIRST_UNROBBED][i]+nums[i]); 
            if(i+1 < nums.size()+2) dp[FIRST_UNROBBED][i+1] = max(dp[FIRST_UNROBBED][i+1], dp[FIRST_UNROBBED][i]);
            
            //ignore the last element if the first has been robbed 
            if(i == nums.size()-1 || i == 1) continue; 
            
            // we robbed the first 
            if(i+2 < nums.size()+2) dp[FIRST_ROBBED][i+2] = max(dp[FIRST_ROBBED][i+2], dp[FIRST_ROBBED][i]+nums[i]); 
            if(i+1 < nums.size()+2) dp[FIRST_ROBBED][i+1] = max(dp[FIRST_ROBBED][i+1], dp[FIRST_ROBBED][i]);
        }
        
        return max(dp[FIRST_UNROBBED][nums.size()+1], max(dp[FIRST_UNROBBED][nums.size()], max(dp[FIRST_ROBBED][nums.size()], max(dp[FIRST_ROBBED][nums.size()+1],dp[FIRST_ROBBED][nums.size()-1])))); 
    }
};
