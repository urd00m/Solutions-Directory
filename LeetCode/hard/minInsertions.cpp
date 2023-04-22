#define MAX 100000000
class Solution {
public:
    int minInsertions(string s) {
        // dp with two pointers 
        int n = s.size();
        vector<vector<int>> dp = vector(n, vector(n, MAX)); 
        
        // base cases
        for(int i = 0; i < n; i++) 
            for(int j = 0; j <= i; j++)
                dp[i][j] = 0; 

        // iterative substructure is
        // i: n-1 -> 0 
        // j: 0 -> n-1
        for(int i = n-1; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {
                if(s[i] == s[j]) 
                    dp[i][j] = dp[i+1][j-1]; 
                dp[i][j] = min(dp[i][j], 1 + dp[i+1][j]); 
                dp[i][j] = min(dp[i][j], 1 + dp[i][j-1]); 
            }
        }
        return dp[0][n-1]; 
    }
};
