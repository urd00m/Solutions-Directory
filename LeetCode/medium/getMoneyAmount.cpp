class Solution {
public:
    int recur(vector<vector<int>>& dp, int l, int r) {
        if(l == r) return 0; // win 

        // memoization 
        if(dp[l][r] != -1) return dp[l][r]; 

        // else iterate through and return the max of all possible counts 
        int ret = INT32_MAX; 
        for(int i = l; i <= r; i++) {
            int cost = -1; 
            if(i == l) cost = i + recur(dp, i+1, r); 
            else if(i == r) cost = i + recur(dp, l, i-1);
            else cost = max(i + recur(dp, l, i-1), i + recur(dp, i+1, r));
            ret = min(ret, cost);
        }
        return dp[l][r] = ret; 
    }

    int getMoneyAmount(int n) {
        // dp 
        // for a given range 
        // pick number and you update both ranges 
        // top down 
        vector<vector<int>> dp = vector(n+1, vector(n+1, -1)); 
        return recur(dp, 1, n);
    }
};
