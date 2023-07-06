class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        // two pointers 
        int ret = INT32_MAX; 
        int l = 0; int r = 0; 
        int cur = 0; 
        while(1) {
            if(cur < target && r == nums.size()) break; 
            else if(cur < target) cur += nums[r++]; 
            else if(cur >= target) {
                ret = min(ret, r - l); 
                cur -= nums[l++]; 
            }
        }
        return (ret == INT32_MAX ? 0 : ret); 
    }
};
