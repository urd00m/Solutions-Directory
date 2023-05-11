class Solution {
public:
    int maxUncrossedLines(vector<int>& nums1, vector<int>& nums2) {
        // dp 
        size_t n = nums1.size(); 
        size_t m = nums2.size(); 
        
        // lets optimize lol why not 
        // vector<vector<int>> map = vector(2001, vector(0, 0)); 
        // for(int i = 0; i < n; i++) 
        //     map[nums2[i]].push_back(i); 
        
        // begin dp 
        vector<vector<int>> dp = vector(n+1, vector(m+1, 0)); 
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i != n && j != m && nums1[i] == nums2[j]) dp[i+1][j+1] = max(dp[i+1][j+1], 1 + dp[i][j]); 
                if(i != n) dp[i+1][j] = max(dp[i+1][j], dp[i][j]);
                if(j != m) dp[i][j+1] = max(dp[i][j+1], dp[i][j]);
            }
        }

        // return 
        return dp[n][m]; 
    }
};
