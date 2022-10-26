class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        // prefix sum (1 idx)
        vector<int> p = vector(nums.size() + 1, 0); 
        for(int i = 0; i < nums.size(); i++) p[i+1] = p[i] + nums[i]; 
        
        // hashmap 
        // only need to find when pref[l]%k == pref[r]%k; 
        unordered_map<int, int> v; v[0] = 0; 
        for(int i = 1; i <= nums.size(); i++) {
            if(v.find(p[i]%k) != v.end() && i-v[p[i]%k] > 1) return true; 
            if(v.find(p[i]%k) == v.end()) v[p[i]%k] = i; 
        }
        return false; 
    }
};
