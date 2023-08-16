class Solution {
public:
    int recur(vector<pair<int, int>>& m, vector<vector<int>>& dp, int l, int r) {
        // base cases 
        if(l == r) return 0; 
        if(l+1 == r) return m[l].first * m[l].second * m[r].second; 

        // memoization 
        if(dp[l][r] != -1) return dp[l][r];

        // recursive step 
        // state is we are in range l, r inclusive
        // update is pick a new place to divide in between 
        // add the two children together
        int best = 0; 
        for(int i = l; i < r; i++) {
            int combined = m[l].first * m[i].second * m[r].second; 
            best = max(best, combined + recur(m, dp, l, i) + recur(m, dp, i+1, r)); 
        }
        return dp[l][r] = best; 
    }

    int maxCoins(vector<int>& nums) {
        // set up matrix chain multiplication 
        size_t n = nums.size(); 
        vector<pair<int, int>> m; 
        m.push_back({1, nums[0]});
        for(int i = 0; i < nums.size()-1; i++) m.push_back({nums[i], nums[i+1]});
        m.push_back({nums[nums.size()-1], 1});

        // begin recursion dp 
        vector<vector<int>> dp = vector(n+1, vector(n+1, -1)); 
        return recur(m, dp, 0, nums.size()); 
    }
};
