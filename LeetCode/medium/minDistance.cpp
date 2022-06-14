class Solution {
public:
    int minDistance(string word1, string word2) {
        vector<vector<int>> dp = vector(word1.size()+1, vector(word2.size()+1, -1)); 
        
        return word1.size()+word2.size()-2*lcs(word1, word2, word1.size(), word2.size(), dp); 
    }

    int lcs(string& X, string& Y, int m, int n, vector<vector<int> >& dp) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m - 1] == Y[n - 1])
            return dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp);

        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        return dp[m][n] = max(lcs(X, Y, m, n - 1, dp),                          lcs(X, Y, m - 1, n, dp));
    }
};
