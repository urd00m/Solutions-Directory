class Solution {
public:
    int numDistinct(string s, string t) {
        // take or leave strategy 
        size_t n = s.size(), m = t.size(); 
        vector<vector<int>> dp(n+1, vector(m+1, 0)); 
        dp[0][0] = 1; 

        // bottom up fashion 
        // update 
        // if(s[i] == t[j]) update i+1, j+1 += i,j 
        // else i+1, j += i,j
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(s[i] == t[j]) dp[i+1][j+1] += dp[i][j]; 
                if(dp[i+1][j] + (long)dp[i][j] <= INT32_MAX) dp[i+1][j] += dp[i][j]; 
            }
        }

        // sum up for ret
        int ret = 0; 
        for(int i = 0; i <= n; i++) ret += dp[i][m]; 
        return ret;
    }
};
