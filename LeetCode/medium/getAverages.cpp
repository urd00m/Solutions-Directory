class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        // literally just maintain prefix sum 
        int div = 2*k + 1; 
        vector<int> ret = vector(nums.size(), -1); 
        
        // setup 
        long long sum = 0;
        for(int i = 0; i < min((size_t)2*k, nums.size()); i++) sum += nums[i]; 

        // start
        for(int i = 2*k; i < nums.size(); i++) {
            sum -= (i == 2*k ? 0 : nums[i - 2*k-1]); 
            sum += nums[i]; 
            ret[i - k] = (sum / div); 
        }
        return ret; 
    }
};
