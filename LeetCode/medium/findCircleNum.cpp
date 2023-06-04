class Solution {
public:
    void flood(vector<vector<int>>& g, vector<int>& v, int cur, size_t n) {
        if(v[cur]) return; 

        // flood 
        v[cur] = 1; 

        // visit neighbors 
        for(size_t i = 0; i < n; i++) 
            if(g[cur][i]) 
                flood(g, v, i, n);    
    }

    int findCircleNum(vector<vector<int>>& isConnected) {
        size_t n = isConnected.size(); 

        // flood fill with visited 
        int ret = 0; 
        vector<int> visited = vector(n, 0); 
        for(size_t i = 0; i < n; i++) 
            if(!visited[i]) {
                ret++; 
                flood(isConnected, visited, i, n); 
            }
        return ret; 
    }
};
