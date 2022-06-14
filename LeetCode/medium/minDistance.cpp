class Solution {
public:
    int minDistance(string word1, string word2) {
        vector<vector<int>> dp = vector(word1.size(), vector(word2.size(), -1)); 
    
        return word1.size()+word2.size()-2*lcs(word1, word2, 0, 0, dp); 
    }
/*
    int lcs(string& X, string& Y, int m, int n, vector<vector<int> >& dp) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m - 1] == Y[n - 1])
            return dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp);

        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        return dp[m][n] = max(lcs(X, Y, m, n - 1, dp), lcs(X, Y, m - 1, n, dp));
    }
*/
    int lcs(string& a, string& b, int i, int j, vector<vector<int> >& dp) {
        if(i == a.size() || j == b.size()) return 0; 
        
        // memoization
        if(dp[i][j] != -1) return dp[i][j]; 
        
        // equal
        if(a[i] == b[j]) 
            return dp[i][j] = 1 + lcs(a, b, i+1, j+1, dp);
        else 
            return dp[i][j] = max(lcs(a, b, i+1, j, dp), lcs(a, b, i, j+1, dp)); 
        
    }
};
