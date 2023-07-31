class Solution {
public:
    int minimumDeleteSum(string s1, string s2) {
        // dp 
        // you can either delete from s1 or s2 until equal 
        // 2 x max(size1, size2) 
        // update if equal you can update for free 
        // + you can choose to delete 1 or the other 
        // dp state i,j: the min deletion up to i,j to make the two strings equal 
        size_t n = max(s1.size(), s2.size()); 
        vector<vector<int>> dp = vector(n+1, vector(n+1, INT32_MAX)); 
        dp[0][0] = 0; 
        for(int i = 0; i < s1.size(); i++) {
            for(int j = 0; j < s2.size(); j++) {
                if(s1[i] == s2[j]) 
                    dp[i+1][j+1] = min(dp[i+1][j+1], dp[i][j]); 

                dp[i+1][j] = min(dp[i+1][j], dp[i][j] + s1[i]); 
                dp[i][j+1] = min(dp[i][j+1], dp[i][j] + s2[j]); 
            }
        }

        // calculate edges 
        int sum = 0; 
        for(int i = s1.size()-1; i >= 0; i--) {
            sum += s1[i]; 
            dp[s1.size()][s2.size()] = min(dp[s1.size()][s2.size()], dp[i][s2.size()] + sum); 
        }
        sum = 0; 
        for(int i = s2.size()-1; i >= 0; i--) {
            sum += s2[i]; 
            dp[s1.size()][s2.size()] = min(dp[s1.size()][s2.size()], dp[s1.size()][i] + sum); 
        }

        return dp[s1.size()][s2.size()];
    }
};
