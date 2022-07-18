class Solution {
public:
    int numDecodings(string s) {
        // recurison with memoization 
        vector<int> dp = vector(s.size(), -1);
        return recur(dp, s, 0);
    }
    
    static int recur(vector<int>& dp, string s, int cur) {
        // base case 
        if(cur >= s.size()) return 1; 
        
        // memoization
        if(dp[cur] != -1) return dp[cur];
        
        // take 1 
        int ret = 0; // 1 indexed 
        if(s[cur]-'0' != 0) ret += recur(dp, s, cur+1);  
        
        // take 2 if valid (first char can only be 1 or 2)(second char can only be 0 to 6)
        if(s[cur]-'0' > 0 && s[cur]-'0' <= 2 && cur+1 < s.size() && ((s[cur] == '1') || (s[cur] == '2' && s[cur+1]-'0' >= 0 && s[cur+1]-'0' <= 6))) ret += recur(dp, s, cur+2); 
        return dp[cur] = ret; 
    }
};
