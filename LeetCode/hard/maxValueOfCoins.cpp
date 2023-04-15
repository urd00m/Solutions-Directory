class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        // dp 
        // O(nk) states 
        // let dp[i][j] represent the maximump profit that can be obtained by from piles[1..i] at most j coins 
        size_t n = piles.size(); 
        vector<vector<int>> dp = vector(n+1, vector(k+1, INT32_MIN)); // 1 index
        dp[0][0] = 0;
        
        // iterate 
        for(size_t i = 0; i < n; i++) {
            vector<int>& p = piles[i]; 
            int tot = 0; 
            for(size_t a = 0; a < p.size()+1; a++) {
                for(size_t j = 0; j <= k; j++) {
                    if(dp[i][j] == INT32_MIN) continue; 
                    if(j+a > k) continue; 
                    dp[i+1][j+a] = max(dp[i+1][j+a], dp[i][j] + tot); 
                }
                if(a != p.size()) tot += p[a]; 
            }
        }

        // for(vector<int>& ary : dp) {
        //     for(int item : ary) cout << item << " ";
        //     cout << endl; 
        // }

        // return 
        return dp[n][k]; 
    }
};

/*
    1     7
    100.  8
    3.    9 

    0 
     
    

*/
