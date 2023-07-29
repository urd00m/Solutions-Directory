class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        // you can either take the chain or lose the chain 
        // LIS 
        sort(pairs.begin(), pairs.end()); 
        size_t n = pairs.size(); 
        vector<int> dp = vector(n, 1); 
        for(size_t i = 0; i < n; i++) {
            for(size_t j = 0; j < i; j++) {
                if(pairs[i][0] > pairs[j][1]) dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        return dp[n-1];
    }
};
