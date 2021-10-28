class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        long n = nums.size(); 
        //bitmask  
        unsigned long size = 1<<nums.size(); 
        vector<vector<int>> ret; 
        for(unsigned long mask = 0; mask < size; mask++) {
            vector<int> add; 
            for(unsigned long i = 0; i < n; i++) {
                if(1<<i & mask) add.push_back(nums[i]); 
            }
            ret.push_back(add); 
        }
            
        return ret; 
    }
};
