#define MOD 1000000007

class Solution {
public:
    int numberOfArrays(string s, int k) {
        // dp 
        size_t n = s.size(); 
        vector<int> dp = vector(n+1, 0); 
        dp[0] = 1; 

        // update 
        for(int i = 0; i < n; i++) {
            string cur = ""; 
            cur += string(1, s[i]); 
            if(cur == "0") continue; // no leading zeroes 
            int j = i; 

            while(j < n && stol(cur) <= k) {
                if(stoi(cur) >= 1) dp[j+1] = (dp[j+1] + dp[i])%MOD;
                j++; 
                if(j < n) cur += string(1, s[j]); 
            }
        }
        return dp[n]; 
    }
};
