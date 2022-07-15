class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        // one index 
        vector<int> dp = vector(s.size()+1, 0);
        dp[0] = 1; 
        for(long i = 1; i < dp.size(); i++) {
            if(dp[i-1] != 1) continue; // previous not possible 
            for(long j = 0; j < wordDict.size(); j++) {
                // Check if it fits 
                if(s.substr(i-1, wordDict[j].size()) == wordDict[j]) {
                    dp[i+wordDict[j].size()-1] = 1; // move forward 
                }
            }
        }
        
        return dp[s.length()] == 1; 
    }
};
