#define MOD 1000000007

class Solution {
public:
    int countGoodStrings(int low, int high, int zero, int one) {
        // dp 
        vector<int> dp = vector(high+1, 0); 
        dp[0] = 1; 
        
        for(int i = 0; i < high; i++) {
            if(i+zero <= high) dp[i+zero] = (dp[i+zero] + dp[i])%MOD;
            if(i+one <= high) dp[i+one] = (dp[i+one] + dp[i])%MOD;
        }

        // sum up
        int ret = 0; 
        for(int i = low; i <= high; i++)
            ret = (ret + dp[i])%MOD;

        return ret; 
    }
};
