class Solution {
public:
    int numTrees(int n) {
        int build[20]{0};   
        build[0] = 1; build[1] = 1;  
        for(long i = 2; i < 20; i++) {
            
            for(long left = 0; left < i; left++) {
                build[i] += build[left]*build[i-left-1]; 
            }
            
        }
        
        return build[n]; 
    }
};

// recursive solution
class Solution {
public:
    int numTrees(int n) {
        vector<vector<int>> dp = vector(n, vector(n, -1)); 
        return recur(dp, 0, n-1); 
    }
    
    static int recur(vector<vector<int>>& dp, int l, int r) {
        if(r <= l) return 1; 
        if(dp[l][r] != -1) return dp[l][r]; 
        
        int ret = 0;
        for(int i = l; i <= r; i++) {
            ret += recur(dp, l, i-1)*recur(dp, i+1,r);
        }
        return dp[l][r] = ret; 
    }
};
