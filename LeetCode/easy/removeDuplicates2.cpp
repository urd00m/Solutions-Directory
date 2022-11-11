class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int tail = 0; 
        int ret = 1; 
        for(int i = 1; i < nums.size(); i++) {
            if(nums[i] != nums[tail]) {
                tail++; 
                nums[tail] = nums[i]; // replace and move on 
                ret++; 
            }
        }

        return ret; 
    }
};
