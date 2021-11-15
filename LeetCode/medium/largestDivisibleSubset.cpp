class Solution {
public:
    vector<vector<int>> dp;     
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        sort(nums.begin(), nums.end()); 
        long n = nums.size(); 
        vector<int> ret; 
        Solution::dp.resize(n);
        for(long i = 0; i < n; i++) Solution::dp[i].resize(0); 
        for(long start = 0; start < n; start++) {
            recur(nums, start); 
            if(Solution::dp[start].size() > ret.size()) ret = Solution::dp[start]; 
        }
        return ret; 
    }
    
    vector<int> recur(vector<int>& nums, int idx) {
        if(idx >= nums.size()) return {}; 
        else if(Solution::dp[idx].size() != 0) return Solution::dp[idx]; 
        else {
            vector<int> ret; 
            for(long i = idx+1; i < nums.size(); i++) {
                if(nums[i] % nums[idx] != 0) continue; 
                vector<int> ans = recur(nums, i);
                if(Solution::dp[idx].size() < ans.size()) Solution::dp[idx] = ans; 
            }
            Solution::dp[idx].push_back(nums[idx]); 
            return Solution::dp[idx]; 
        }
    }
};
