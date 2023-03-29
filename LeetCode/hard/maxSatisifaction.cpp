#define INTMIN -1000000000

class Solution {
public:
    int maxSatisfaction(vector<int>& s) {
        // sort
        sort(s.begin(), s.end()); 

        // dp 
        // index * time 
        size_t n = s.size(); 
        vector<vector<int>> dp = vector(n+1, vector(n+2, INTMIN)); 
        dp[0][1] = 0; 
        for(int i = 0; i < n; i++) {
            for(int t = 1; t < n+1; t++) {
                // you can take it or you don't take it 
                int sat = s[i]; 
                dp[i+1][t+1] = max(dp[i+1][t+1], dp[i][t] + (sat*t));
                dp[i+1][t] = max(dp[i+1][t], dp[i][t]); 
            }
        }

        // return answer 
        int ret = 0; 
        for(int t = 1; t < n+2; t++)
            ret = max(ret, dp[n][t]); 
        return ret; 
    }
};
