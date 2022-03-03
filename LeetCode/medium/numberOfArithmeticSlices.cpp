class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int ret = 0; 
        
        if(nums.size() < 3) return 0;
        
        for(long i = 0; i < nums.size()-2; i++) {
            int diff = nums[i+1] - nums[i]; //since it must be contigous 
            for(long j = i+2; j < nums.size(); j++) {
                if(diff == nums[j] - nums[j-1]) ret++; 
                else break; 
            }
        }
        
        return ret; 
    }
};
