class Solution {
public:
    double soupServings(int n) {
        // explore all pahts + return (recursion )
        if(n > 5000) return 1.0; 

        // dp 
        // a is rows b is columns 
        double ret = 0.0; 
        vector<vector<double>> dp = vector(n+1, vector(n+1, 0.0)); 
        dp[n][n] = 1.0; 
        for(int i = n; i >= 1; i--) {
            for(int j = n; j >= 1; j--) {
                // all four probabilities 
                dp[max(i-100, 0)][j] += dp[i][j]/4.0;
                dp[max(i-75, 0)][max(j-25, 0)] += dp[i][j]/4.0;
                dp[max(i-50, 0)][max(j-50, 0)] += dp[i][j]/4.0;
                dp[max(i-25, 0)][max(j-75, 0)] += dp[i][j]/4.0;
            }
        }
        ret += dp[0][0]/2.0;

        // get ans 
        for(int i = 1; i <= n; i++) {
            ret += dp[0][i]; 
        }
        return ret; 
    }
};
