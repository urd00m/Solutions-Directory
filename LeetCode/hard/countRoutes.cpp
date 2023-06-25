#define MOD 1000000007

class Solution {
public:
    int cost(vector<int>& locations, int a, int b) {
        return abs(locations[a] - locations[b]); 
    }

    int countRoutes(vector<int>& locations, int start, int finish, int fuel) {
        // dp can construct a graph 
        // state: cur pos * fuel left --> stores number of ways to reach this position 
        // update, iterate through all states and visit all neighbors (fuel decreasing as fuel can decrease but can't increase)
        size_t n = locations.size(); 
        vector<vector<int>> dp = vector(fuel+1, vector(n, 0)); 
        dp[fuel][start] = 1; 

        // begin dp 
        for(int f = fuel; f >= 0; f--) {
            for(size_t i = 0; i < n; i++) {
                for(size_t j = 0; j < n; j++) {
                    if(i == j) continue; 
                    int c = cost(locations, i, j);
                    if(f - c >= 0) dp[f - c][j] = (dp[f - c][j]+dp[f][i])%MOD;
                }
            }
        } 

        // ans 
        int ret = 0; 
        for(int f = 0; f <= fuel; f++) {
            ret = (ret+dp[f][finish])%MOD;
        }
        return (int)ret; 
    }
};

// could be made more efficient lol (the repeated func calls to cost is not good and can be memoized)
