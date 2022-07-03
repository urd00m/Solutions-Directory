class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        // base case 
        if(nums.size() == 1) return 1; 
        
        // greedy only take the ones that can be used in the sequence 
        int ret = 1; 
        int neg = -1; 
        for(long i = 1; i < nums.size(); i++) {
            if(nums[i]-nums[i-1] > 0 && neg != 0) {
                ret++; neg = 0; 
            }
            else if(nums[i]-nums[i-1] < 0 && neg != 1) {
                ret++; neg = 1; 
            }
        }
        
        return ret; 
    }
};
