class Solution {
public:
    int findMaxForm(vector<string>& strs, int m, int n) { // dp         
        // create counts 
        vector<int> counts0, counts1; 
        for(string s : strs) { 
            int ones = 0; 
            int zeros = 0; 
            for(char c : s){
                if(c == '0') zeros++;
                else if(c == '1') ones++; 
            }
            counts0.push_back(zeros);
            counts1.push_back(ones); 
        }
        
        // dp 
        vector<vector<int>> dp = vector(m+1, vector(n+1, 0)); //m by n vector 
        dp[0][0] = 1; 
        vector<vector<int>> loc; //x by 2 
        loc.push_back({0, 0}); // start with, 0,0 
        
        // iterate 
        int ret = 0; 
        for(long i = 0; i < counts0.size(); i++) { //use each count once 
            // go in reverse to not hit already hit items 
            vector<vector<int>> changes; 
            for(long j = loc.size()-1; j >= 0; j--) {
                if(loc[j][0] + counts0[i] <= m && loc[j][1] + counts1[i] <= n) {
                    if(dp[loc[j][0] + counts0[i]][loc[j][1] + counts1[i]] == 0) 
                        loc.push_back({loc[j][0] + counts0[i], loc[j][1] + counts1[i]});
                    changes.push_back({loc[j][0] + counts0[i], loc[j][1] + counts1[i], dp[loc[j][0]][loc[j][1]] + 1});                    
                    ret = max(ret, dp[loc[j][0]][loc[j][1]]); 
                }
            }
            // do changes 
            for(vector<int> item : changes) 
                dp[item[0]][item[1]] = max(dp[item[0]][item[1]], item[2]); 
        }
        
        return ret; 
        
    }
};	

