class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        // dp lol 
        // or a graph 
        // just gonna do simple dp 
        size_t n = days.size();
        vector<int> d = vector(396, 0);
        for(int day : days) d[day] = 1; 

        // dp 
        vector<int> dp = vector<int>(396, INT32_MAX); 
        dp[0] = 0;  
        for(int i = 0; i < 395; i++) {
            if(d[i] == 0) dp[i+1] = min(dp[i+1], dp[i]); 
            else {
                if(i+1 < 396) dp[i+1] = min(dp[i+1], dp[i] + costs[0]); 
                if(i+7 < 396) dp[i+7] = min(dp[i+7], dp[i] + costs[1]); 
                if(i+30 < 396) dp[i+30] = min(dp[i+30], dp[i] + costs[2]); 
            }
        }

        return dp[395]; 
    }
};
