class Solution {
public:
    vector<vector<int>> dp; 

    // memoization 
    int recur(int l, int r, string& s) {
        // base cases 
        if(l > r) return 0; 
        else if(l == r) return 1; 
        else if(s[l] == s[r]) return recur(l+1, r, s); 
        else if(dp[l][r] != -1) return dp[l][r]; 
        else {
            int ret = recur(l+1, r, s) + 1;  // just take it 
            for(int i = l+1; i < r; i++) {
                if(s[l] == s[i]) 
                    ret = min(ret, recur(l,i,s) + recur(i+1, r, s));
            }
            dp[l][r] = ret; 
            return ret; 
        }
    }

    int strangePrinter(string s) {
        // dp 
        dp = vector(s.size(), vector(s.size(), -1));
        return recur(0, s.size()-1, s);  
    }
};
