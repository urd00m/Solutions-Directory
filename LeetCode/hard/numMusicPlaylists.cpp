#define MOD 1000000007

class Solution {
public:
    int numMusicPlaylists(int n, int goal, int k) {
        // base recursive backtracking 
        // n children n depth n^n (not good)
        // every song must be played once 
        // clever no need to keep track of the previous -> you only need to count! 
        vector<vector<int>> dp = vector(goal+1, vector(n+1, 0)); 
        dp[0][0] = 1; 
        for(int i = 0; i < goal; i++) {
            for(int j = 0; j <= n; j++) {
                // add a new unique one 
                if(j < n) dp[i+1][j+1] = ((long)dp[i+1][j+1] + ((long)dp[i][j] * (n-j)))%MOD;
                if(j > k) dp[i+1][j] = ((long)dp[i+1][j] + ((long)dp[i][j] * (j-k)))%MOD; 
            }
            cout << endl; 
        }
        return dp[goal][n]; 
    }
};
