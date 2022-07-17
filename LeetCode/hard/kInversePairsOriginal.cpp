#define MOD 1000000007
class Solution {
public:
    int kInversePairs(int n, int k) { 
        /*
            (n==2) 2 1, 1 2 (1, 0)(1) 
            (n==3) 3 2 1   2 3 1  2 1 3  3 1 2   1 3 2   1 2 3  (2 1 0 3 2 1)(9)  
            (n==4) 4 3 2 1,  3 4 2 1, 3 2 4 1, 3 2 1 4 (6, 5, 4, 3)   
        */
        
        // dp (N*N) states, update is O(N)
        if(n == 1 && k > 0) return 0; 
        else if(k == 0) return 1; 
        
        vector<vector<int>> dp = vector(n+1, vector(k+1, 0));  // one index everything 
        dp[2][0] = 1; dp[2][1] = 1; 
        for(long i = 2; i < n; i++) { // cur n 
            for(long k2 = 0; k2 <= k; k2++) {  // cur k
                if(dp[i][k2] == 0) continue; 
                for(long j = 0; j <= i; j++) { // cur update 
                    if(k2+j <= k) dp[i+1][k2+j] = (dp[i+1][k2+j]+dp[i][k2])%MOD; 
                    else break; 
                }
            }
        }
        
        return dp[n][k]; 
    }
};
