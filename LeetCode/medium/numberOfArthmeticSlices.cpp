class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        // simple dp
        vector<int> dp = vector(nums.size(), 0);
        int occ = 1; 
        int inc = INT32_MIN; 
        for(long i = 1; i < nums.size(); i++) {
            if(inc == nums[i]-nums[i-1]) 
                occ++; 
            else {
                inc = nums[i]-nums[i-1]; 
                occ = 2; 
            }
            
            if(occ >= 3)
                dp[i] += dp[i-1] + occ-2; 
            else 
                dp[i] = dp[i-1];
        }
        
        return dp[nums.size()-1];
    }
};
