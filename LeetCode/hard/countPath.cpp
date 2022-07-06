#define MOD 1000000007
class Solution {
public:
    static bool compare(vector<int>& a, vector<int>& b) {
        return a[0] < b[0]; 
    }
    
    int countPaths(vector<vector<int>>& grid) {
        long n = grid.size(); long m = grid[0].size(); 
        vector<vector<int>> squash = vector(n*m, vector(3, -1)); // value, row, col 
        for(long i = 0; i < n; i++)
            for(long j = 0; j < m; j++) {
                squash[i*m+j][0] = grid[i][j]; 
                squash[i*m+j][1] = i; 
                squash[i*m+j][2] = j; 
            }
        
        //sort 
        sort(squash.begin(), squash.end(), compare); 
        
        // do dp but in ascending order
        vector<vector<int>> dp = vector(n, vector(m, 1)); 
        for(vector<int> next : squash) {
            long i = next[1];
            long j = next[2]; 
            int val = next[0]; 
            
            //check 4 directions 
            if(i+1 < n && grid[i+1][j] > val)
                dp[i+1][j] = (dp[i+1][j]+dp[i][j])%MOD; 
            if(i-1 >= 0 && grid[i-1][j] > val)
                dp[i-1][j] = (dp[i-1][j]+dp[i][j])%MOD; 
            if(j+1 < m && grid[i][j+1] > val)
                dp[i][j+1] = (dp[i][j+1]+dp[i][j])%MOD; 
            if(j-1 >= 0 && grid[i][j-1] > val)
                dp[i][j-1] = (dp[i][j-1]+dp[i][j])%MOD; 
        }
        
        // sum up everything 
        int ret = 0; 
        for(long i = 0; i < n; i++) {
            for(long j = 0; j < m; j++) {
                ret = (ret + dp[i][j])%MOD; 
            }
        }
        
        return ret; 
        
    }
};
