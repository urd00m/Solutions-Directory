class Solution {
public:
   
    static bool compare(const vector<int>& a, const vector<int>& b) {
        return a[0] < b[0]; 
    }

    int maxValue(vector<vector<int>>& events, int k) {
        // k * n dp 
        // upperbound (bin search) to determine where to go next 
        sort(events.begin(), events.end()); 
        size_t n = events.size();
        vector<vector<int>> dp = vector(k+1, vector(n+1, 0)); 

        // begin dp 
        // iterate through all possible k and n 
        // updatae either accept or don't accept 
        // accept: move up k and to the upper bound value 
        // reject: stay on k and move update cell to the right 
        for(int i = 0; i < k; i++) {
            for(size_t j = 0; j < n; j++) {
                // accept 
                vector<int> temp = {events[j][1]}; // picking the ending 
                int b = upper_bound(events.begin(), events.end(), temp, compare) - events.begin();
                dp[i+1][b] = max(dp[i+1][b], dp[i][j] + events[j][2]); // add value 
                // reject 
                dp[i][j+1] = max(dp[i][j+1], dp[i][j]); 
            }
        }

        // find max 
        int ret; 
        for(int i = 0; i <= k; i++) 
            for(size_t j = 0; j <= n; j++) 
                ret = max(ret, dp[i][j]); 
        return ret; 
    }
};
