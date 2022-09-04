class Solution {
public:
    int numSquares(int n) {
        vector<int> squares; 
        
        // generate perfect squares up to 10^4 
        int num = 1; 
        while(num*num < n+1) {
            squares.push_back(num*num);
            num++; 
        }
        
        // dp 
        vector<int> dp = vector(n+1, 1000000); 
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int square : squares) {
                if(i + square <= n) dp[i+square] = min(dp[i+square], dp[i] + 1); 
            }
        }
        
        return dp[n]; 
    }
};
