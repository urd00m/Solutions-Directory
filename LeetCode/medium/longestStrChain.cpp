class Solution {
public:
    int longestStrChain(vector<string>& words) {
        // organize by size 
        vector<vector<string>> bysize = vector(18, vector<string>()); 
        int start = INT32_MAX;
        for(string word : words) {
            start = word.size() < start ? word.size() : start; 
            bysize[word.size()].push_back(word);
        }

        // dp
        vector<vector<int>> dp = vector(17, vector(1001, -1)); 
        for(int j = 0; j < bysize[start].size(); j++) 
            recur(bysize, dp, start, j);
        
        // look through dp 
        int maxret = 0; 
        for(vector<int> ary : dp) {
            for(int item : ary) {
                maxret = max(maxret, item); 
            }
        }
        
        return maxret; 
    }
    
    int recur(vector<vector<string>>& bysize, vector<vector<int>>& dp, int i, int j) {
        if(i == 17 || bysize[i].size() == 0)
            return 0; 
        
        // memoization
        if(dp[i][j] != -1)
            return dp[i][j]; 
        
        // cases 
        string curword = bysize[i][j]; 
        int maxchain = 0; 
        int maxnew = 0; 
        for(int jdx = 0; jdx < bysize[i+1].size(); jdx++) {
            if(isPred(curword, bysize[i+1][jdx])) 
                maxchain = max(maxchain, recur(bysize, dp, i+1, jdx));
            else 
                recur(bysize, dp, i+1, jdx); 
        }
        
        return dp[i][j] = max(maxchain+1, maxnew); 
    }
    
    bool isPred(string& a, string& b) {
        if(a.size() != b.size()-1) return false; 
        size_t i = 0;
        size_t j = 0;
        bool skipped = false; 
        while(i < a.size()) {
            if(a[i] == b[j]) {
                i++;
                j++;    
                continue; 
            }
            
            if(!skipped) {
                skipped = true; 
                j++; 
            }
            else 
                return false; 
        }
        return true;
    }
};

/*
    Faster than 82.61% of submissions. More of an upgraded kind of dp, by creating 16 layers we can reduce the runtime needed along with dp. On top of that we can create a fast isPred algorithm.
*/
