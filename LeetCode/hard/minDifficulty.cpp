
class Solution {
public:
//     static const int N = 1e4;  // limit for array size
//     static int n;  // array size
//     static int t[2 * N];

//     void build() {  // build the tree
//       for (int i = n - 1; i > 0; --i) t[i] = max(t[i<<1], t[i<<1|1]);
//     }

//     void modify(int p, int value) {  // set value at position p
//       for (t[p += n] = value; p > 1; p >>= 1) t[p>>1] = max(t[p], t[p^1]);
//     }

//     int query(int l, int r) {  // sum on interval [l, r)
//       int res = 0;
//       for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
//         if (l&1) res = max(res, t[l++]);
//         if (r&1) res = max(res, t[--r]);
//       }
//       return res;
//     }
    
    
    
    int minDifficulty(vector<int>& jobDifficulty, int d) {
        // dp 
        long n = jobDifficulty.size(); 
        vector<vector<int>> dp = vector(d+1, vector(n+1, INT32_MAX)); 
        
        // // seg tree 
        // for(int i = 0; i < n; i++) t[i + n] = jobDifficulty[i];
        // build(); 
        
        // iteration 
        dp[0][0] = 0; 
        for(int day = 0; day < d; day++) {
            for(int i = 0; i < n; i++) {
                int max_diff = 0; 
                if(dp[day][i] == INT32_MAX) continue; 
                for(int i2 = i; i2 < n; i2++) {
                    max_diff = max(max_diff, jobDifficulty[i2]); 
                    dp[day+1][i2+1] = min(dp[day+1][i2+1], dp[day][i] + max_diff); 
                }
            }
        }
        
        if(dp[d][n] == INT32_MAX) return -1; 
        else return dp[d][n]; 
    }
};
