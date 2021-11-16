class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        for(long i = 0; i < nums.size(); i++) {
            for(long j = i+1; j < nums.size(); j++) {
                if(nums[i] + nums[j] == target) return {static_cast<int>(i), static_cast<int>(j)}; 
            }
        }
        
        return {0, 0}; 
    }
};
