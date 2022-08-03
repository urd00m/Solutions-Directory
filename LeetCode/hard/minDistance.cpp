class Solution {
public:
    int minDistance(string word1, string word2) {
        // dp state O(n*m) update O(1) 
        if(word1.size() == 0 && word2.size() == 0) return 0;     
        if(word1.size() == 0 && word2.size() != 0) return word2.size();     
        if(word1.size() != 0 && word2.size() == 0) return word1.size();     
            
        // update 
        // insert, delete, replace 
        long n = word1.size(); long m = word2.size(); 
        vector<vector<int>> dp = vector(n+2, vector(m+2, 1000000)); 
        
        // dp 
        dp[0][0] = 0; 
        for(long j = 0; j <= m; j++) {
            for(long i = 0; i <= n; i++) {
                if(j != m && word1[i] == word2[j])
                    dp[i+1][j+1] = min(dp[i+1][j+1], dp[i][j]); 
                    
                // insert (i doesn't change, but j increases by 1)
                dp[i][j+1] = min(dp[i][j+1], dp[i][j]+1); 
                
                // delete 
                dp[i+1][j] = min(dp[i+1][j], dp[i][j]+1); 
                
                // replace 
                dp[i+1][j+1] = min(dp[i+1][j+1], dp[i][j]+1); 
            }
        }
        
        /*
        for(vector<int> ary : dp) {
            for(int item : ary)
                cout << item << " ";
            cout << endl; 
        }
        */
        
        return dp[n][m]; 
    }
};
