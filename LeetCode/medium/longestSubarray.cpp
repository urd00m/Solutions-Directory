class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        // iterate 
        int ret = 0; 
        int prev = 0; 
        int ones = 0; 
        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == 1) {
                ones++;
                ret = max(prev + ones, ret); 
            }
            else {
                prev = ones; 
                ones = 0; 
            }
        }
        if(nums.size() == ret) return ret-1; 
        return ret; 
    }
};
