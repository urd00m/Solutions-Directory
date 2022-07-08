class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        long n = nums.size();
        
        // kadanes 
        int ret = INT32_MIN; 
        int cur = 0; 
        for(int i = 0; i < n; i++) {
            cur += nums[i]; 
            ret = max(ret, cur); 
            if(cur < 0) cur = 0; 
        }
        
        // if at ends
        vector<int> suffix_sums = vector(n, 0); 
        suffix_sums[n-1] = nums[n-1]; 
        for(int i = n-2; i >= 0; i--) 
            suffix_sums[i] = nums[i]+suffix_sums[i+1]; 
        
        // determine max 
        vector<int> max_right = vector(n, 0); 
        max_right[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--)
            max_right[i] = max(max_right[i+1], suffix_sums[i]); 
        
        // max 
        cur = 0; 
        for(int i = 0; i < n-2; i++) {
            cur += nums[i];
            ret = max(ret, cur+max_right[i+2]); 
        }
        return ret; 
    }
};
