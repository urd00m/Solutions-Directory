class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int max = 0; 
        int count = 0; 
        for(unsigned long i = 0; i < nums.size(); i++) {
            if(nums[i] == 1) {
                max = max > ++count ? max : count;
            }
            else count = 0; 
        }
        
        return max; 
    }
};
