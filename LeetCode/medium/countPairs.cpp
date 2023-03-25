class Solution {
public:
    int component_size(int cur, vector<vector<int>>& adjlist, vector<int>& v) {
        if(v[cur]) return 0; 
        v[cur] = 1; 

        int ret = 1; 
        for(int n : adjlist[cur]) {
            ret += component_size(n, adjlist, v); 
        }
        return ret; 
    }

    long long countPairs(int n, vector<vector<int>>& edges) {
        // find connect components then count up by retaining others and current componnet size 
        vector<vector<int>> adjlist = vector(n, vector(0, 0)); 
        for(vector<int>& e : edges) {
            adjlist[e[0]].push_back(e[1]); 
            adjlist[e[1]].push_back(e[0]); 
        }

        // find components 
        vector<int> v = vector(n, 0); 
        vector<int> c; 
        for(int i = 0; i < n; i++) 
            if(!v[i]) c.push_back(component_size(i, adjlist, v)); 
        
        // sum up 
        long long ret = 0; 
        for(int i = 0; i < c.size(); i++) {
            ret += (long long)c[i]*((long long)n-c[i]); 
            n -= c[i]; 
        }
        return ret; 
    }
};
