#define MOD 1000000007

class Solution {
public:
    vector<int> pow_cache; 

    int numSubseq(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end()); 
        Solution::pow_cache = vector(nums.size(), -1); 
        Solution::pow_cache[0] = 1; 
        for(int i = 1; i < nums.size(); i++) {
            Solution::pow_cache[i] = (Solution::pow_cache[i-1] << 1)%MOD;
        }

        //two pointers 
        int ret = 0; 
        int l = 0, r = nums.size()-1; 
        while(l <= r) {
            if(nums[l] + nums[r] > target) r--; 
            else {
                ret = (ret + Solution::pow_cache[r-l])%MOD; 
                l++; 
            }
        }
        return ret; 
    }
};
