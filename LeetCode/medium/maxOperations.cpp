class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end()); 
        int ret = 0; 
        // two pointers 
        long r = nums.size()-1, l = 0; 
        while(l < r) {
            if(nums[l]+nums[r] == k) {
                ret++; 
                l++;
                r--; 
            }
            else if(nums[l]+nums[r] > k) {
                r--; 
            }
            else { //nums[l]+nums[r] < k
                l++; 
            }
        }
        
        return ret; 
    }
};
