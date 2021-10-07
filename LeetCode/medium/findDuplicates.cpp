class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        int* count = new int[nums.size()+1]{0}; //count the duplicates 
        vector<int> ret; 
        for(long i = 0; i < nums.size(); i++) {
            if(++count[nums[i]] == 2) {
                ret.push_back(nums[i]);
            }
        }
        return ret; 
    }
};
