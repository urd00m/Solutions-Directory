class Solution {
public:
    static bool compare(vector<int>& a, vector<int>& b) {
        return (a[0] == b[0] ? a[1]>b[1] : a[0] < b[0]); 
    }

    int maxEnvelopes(vector<vector<int>>& envelopes) {
        // LIS 
        sort(envelopes.begin(),envelopes.end(), compare); 

        // begin 
        // size_t n = envelopes.size(); 
        // vector<int> dp = vector(n, 1); 
        // int ret = 0; 
        // for(size_t i = 0; i < n; i++) {
        //     for(size_t j = 0; j < i; j++) {
        //         if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) dp[i] = max(dp[i], dp[j]+1);
        //     }
        //     ret = max(ret, dp[i]); 
        // }

        // binary search LIS 
        size_t n = envelopes.size();
        vector<int> dp; 
        for(int i = 0; i < n; i++) {
            auto idx = lower_bound(dp.begin(), dp.end(), envelopes[i][1]); 
            if(idx == dp.end()) dp.push_back(envelopes[i][1]); 
            else *idx = envelopes[i][1]; 
        }

        return dp.size(); 
    }
};
