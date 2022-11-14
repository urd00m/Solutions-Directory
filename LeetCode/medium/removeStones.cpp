class Solution {
public:
    unordered_map<int, int> par; 
    int node_heads; 

    int find_par(int cur) {
        if(par.find(cur) == par.end()) {
            par[cur] = cur; 
            node_heads++; 
        }

        int p = cur; 
        while(par[p] != p) p = par[p];
        return p;
    }

    void myUnion(int c, int p) {
        int par_c = find_par(c); 
        int par_p = find_par(p); 

        if(par_c == par_p) return; 
        else {
            par[par_c] = par_p; 
            node_heads--; 
        }
    }

    int removeStones(vector<vector<int>>& stones) {
        // ufds 
        size_t n = stones.size(); 
        if(n == 1) return 0; 

        // reset 
        Solution::node_heads = 0; 
        Solution::par.clear(); 

        // begin 
        for(vector<int>& v : stones) 
            myUnion(v[0] + 10001, v[1]); 

        return n - Solution::node_heads;
    }
};
