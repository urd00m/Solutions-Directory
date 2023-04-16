#define MOD 1000000007 
class Solution {
public:
    int numWays(vector<string>& words, string& target) {
        // dp 
        // for the (exclusive) ith character having used the previous j word positions (exclusive) the total number of ways to make it 
        size_t n = words[0].size(); 
        size_t m = target.size(); 

        // create a count 
        vector<vector<long>> occ = vector(n, vector(26, 0L));
        for(string& w : words) 
            for(size_t i = 0; i < n; i++) 
                occ[i][w[i] - 'a']++; 

        // dp 
        vector<long> dp = vector(m+1, 0L); 
        dp[0] = 1L; 
        for(size_t i = 0; i < n; i++) 
            for(int j = m-1; j >= 0; j--) {
                dp[j+1] = (dp[j+1] + dp[j] * occ[i][target[j]-'a'])%MOD;
            }

        // ret
        return dp[m]; 
    }
};
