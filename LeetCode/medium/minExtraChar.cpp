class Solution {
public:
    int minExtraChar(string s, vector<string>& dictionary) {
        // dp 
        // create O(1) struct 
        unordered_set<string> d; 
        for(string& i : dictionary) d.insert(i); 

        // begin dp 
        vector<int> dp = vector(s.size(), INT32_MAX); // stores amount left over
        dp[0] = 0; 
        if(d.find(to_string(s[0])) == d.end()) dp[0] = 1; 
        for(int i = 0; i < s.size(); i++) {
            for(int j = 0; j <= i; j++) { // create substring j -> i
                string c = s.substr(j, i-j+1); 
                if(d.find(c) != d.end())  
                    if(j > 0) dp[i] = min(dp[i], dp[j-1]); 
                    else dp[i] = 0; 
            }
            if(i > 0) dp[i] = min(dp[i], dp[i-1] + 1);
        }
        return dp[s.size()-1];
    }
};
