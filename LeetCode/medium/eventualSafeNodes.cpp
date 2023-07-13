class Solution {
public:
    bool recur(int cur, vector<int>& c, vector<int>& b, vector<vector<int>>& graph) { // return true if cycle 
        if(c[cur] != -1) return c[cur]; 
        if(b[cur] == 1)  return true; 

        // iterate 
        b[cur] = 1; 
        bool cycle = false; 
        for(int n : graph[cur]) if(recur(n, c, b, graph)) cycle = true; 
        b[cur] = 0; 

        if(cycle) c[cur] = 1; 
        else c[cur] = 0; 
        return c[cur]; 
    }

    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        size_t n = graph.size(); 

        // find cycles 
        vector<int> c = vector(n, -1); 
        vector<int> b = vector(n, 0); 
        for(size_t i = 0; i < n; i++) recur(i, c, b, graph); 
        
        // ret
        vector<int> ret; 
        for(int i = 0; i < n; i++) {
            if(!c[i]) ret.push_back(i); 
        }
        return ret; 
    }
};
