class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        // dp / graph problem 
        size_t m = matrix.size(); 
        size_t n = matrix[0].size(); 

        // construct DAG 
        vector<vector<int>> indegree = vector(m, vector(n, 0)); 
        vector<vector<vector<pair<int, int>>>> adjlist(m, vector<vector<pair<int,int>>>(n, vector<pair<int,int>>(0, {0, 0}))); 
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i > 0 && matrix[i-1][j] > matrix[i][j]) {
                    adjlist[i][j].push_back({i-1, j}); 
                    indegree[i-1][j]++;
                }
                if(i < m-1 && matrix[i+1][j] > matrix[i][j]) {
                    adjlist[i][j].push_back({i+1, j}); 
                    indegree[i+1][j]++; 
                }
                if(j > 0 && matrix[i][j-1] > matrix[i][j]) {
                    adjlist[i][j].push_back({i, j-1}); 
                    indegree[i][j-1]++; 
                }
                if(j < n-1 && matrix[i][j+1] > matrix[i][j]) {
                    adjlist[i][j].push_back({i, j+1}); 
                    indegree[i][j+1]++; 
                }
            }
        }

        // find longest path in DAG (topo sort + dp)
        vector<vector<int>> dp = vector(m, vector(n, 0)); 
        queue<pair<int,int>> q; 
        for(int i = 0; i < m; i++) 
            for(int j = 0; j < n; j++)
                if(indegree[i][j] == 0)
                    q.push({i, j}); 

        // begin topo + dp hybrid 
        int ret = 0; 
        while(!q.empty()) {
            pair<int,int> c = q.front(); q.pop(); 

            // update children 
            for(pair<int, int> next : adjlist[c.first][c.second]) {
                dp[next.first][next.second] = max(dp[next.first][next.second], dp[c.first][c.second] + 1); 
                if(--indegree[next.first][next.second] == 0) q.push(next); 
            }
            ret = max(ret, dp[c.first][c.second]);
        }
        return ret+1; 
    }
};
