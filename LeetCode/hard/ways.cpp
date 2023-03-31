#define ISAPPLE(x) (x == 'A')
#define MOD 1000000007

// a b 

// c d 

class Solution {
public:
    int appleQuery(vector<vector<int>>& q, int a, int b, int c, int d) {
        return q[c][d] - q[c][b-1] - q[a-1][d] + q[a-1][b-1]; 
    }

    int ways(vector<string>& pizza, int cuts) {
        // dp with large state change 
        // dp state dp[i][j][k] where the remaining slice is (i,j) to (n,m) with k cuts used 
        size_t n = pizza.size(), m = pizza[0].size(); 
        vector<vector<vector<int>>> dp = vector(n+1, vector(m+1, vector(cuts, 0))); 
        dp[1][1][0] = 1; 

        // set up O(1) query for apples 
        vector<vector<int>> q = vector(n+1, vector(m+1, 0)); // one indexed! 
        for(size_t i = 1; i <= n; i++) {
            for(size_t j = 1; j <= m; j++) {
                q[i][j] += q[i-1][j] + q[i][j-1] - q[i-1][j-1]; 
                if(ISAPPLE(pizza[i-1][j-1]) == true) q[i][j]++; 
            }
        }
        if(cuts == 1) return (appleQuery(q, 1, 1, n, m) > 1);  

        // dp 
        for(size_t k = 0; k < cuts-1; k++) {
            for(size_t i = 1; i <= n; i++) {
                for(size_t j = 1; j <= m; j++) {
                    if(dp[i][j][k] == 0) continue; // no need to run not valid piece 

                    // for each component we can make some cuts 
                    for(size_t v = j+1; v <= m; v++) {
                        // make sure both components have apples 
                        if(appleQuery(q, i, j, n, v-1) < 1 || appleQuery(q, i, v, n, m) < 1) continue; 
                        dp[i][v][k+1] = (dp[i][v][k+1] + dp[i][j][k])%MOD;
                    }
                    for(size_t h = i+1; h <= n; h++) {
                        // make sure both components have apples 
                        if(appleQuery(q, i, j, h-1, m) < 1 || appleQuery(q, h, j, n, m) < 1) continue; 
                        dp[h][j][k+1] = (dp[h][j][k+1] + dp[i][j][k])%MOD;
                    }
                }
            }
        }

        // for(int k = 0; k < cuts; k++) {
        //     for(int i = 1; i <= n; i++) {
        //         for(int j = 1; j <= m; j++) {
        //             cout << dp[i][j][k] << " "; 
        //         }
        //         cout << endl; 
        //     }
        //     cout << endl; 
        // }
                

        // get answer
        int ret = 0; 
        for(size_t i = 1; i <= n; i++) 
            for(size_t j = 1; j <= m; j++) 
                if(dp[i][j][cuts-1] != -1)
                    ret = (ret + dp[i][j][cuts-1])%MOD;  
        return ret; 
    }
};
