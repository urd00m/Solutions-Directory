class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        //the moment you dip negative you restart 
        int maxSum = INT32_MIN;
        int curSum = INT32_MIN; 
        for(long i = 0; i < nums.size(); i++) {
            maxSum = max(curSum, maxSum); 
            if(curSum < 0) curSum = 0; 
            curSum += nums[i];
        }
        maxSum = max(maxSum, curSum); 
        return maxSum; 
    }
};
