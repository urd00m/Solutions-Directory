#define MOD 1000000007
class Solution {
public:
    int kInversePairs(int n, int k) { 
        //dp[i][j] denote till i numbers how many jth inversion pair wala permutations are there
        vector<vector<int>> dp(n+1,vector<int>(k+1,0));
        dp[0][0]=0;
        for(int i=1;i<=k;i++){
            dp[1][i]=0;
        }
        for(int i=1;i<=n;i++){
            dp[i][0]=1;
        }

        // dp 
        for(int i=2;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])%MOD;
                if(j-i>=0){
                    dp[i][j]=(dp[i][j]-dp[i-1][j-i]+MOD)%MOD;
                }
            }         
        }
        return dp[n][k];
    }
};

// not my code, but the code takes advantage of overlapping calls to dp[n][k]
