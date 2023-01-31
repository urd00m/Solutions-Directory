class Solution {
public:
    int bestTeamScore(vector<int>& scores, vector<int>& ages) {
        // LIS DP 
        // sort in ascending age 
        int n = scores.size(); 
        vector<pair<int,int>> p; 
        for(int i = 0; i < n; i++) p.push_back({ages[i], scores[i]}); 
        sort(p.begin(), p.end()); 

        // dp
        int ret = 0; 
        vector<int> dp = vector(n, 0); // one index 
        for(int i = 0; i < n; i++) {
            dp[i] = p[i].second; 
            for(int j = i-1; j >= 0; j--) {
                if(p[i].second >= p[j].second) dp[i] = max(dp[i], p[i].second + dp[j]); 
            }
            ret = max(ret, dp[i]); 
        }
        return ret; 
    }
};
