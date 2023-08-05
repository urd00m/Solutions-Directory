class Solution {
public:
    int findMin(vector<int>& nums) {
        // check endpoints 
        int l = 0, r = nums.size()-1; 
        while(l < r) {
            int m = (l+r)/2; 

            // determine if in rotated or not rotated chunk 
            if(nums[l] < nums[r]) { // reg 
                return nums[l]; 
            }
            else { // rotate
                if(nums[m] >= nums[l]) l = m + 1; 
                else r = m; 
            }
        }
        return nums[l]; 
    }
};
