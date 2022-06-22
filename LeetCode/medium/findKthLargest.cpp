class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        //sort 
        sort(nums.begin(), nums.end()); 
        
        //search in reverse 
        return nums[nums.size()-k];
    }
};
