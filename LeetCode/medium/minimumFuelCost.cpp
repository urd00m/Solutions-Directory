class Solution {
public:

    vector<long long> dfs(vector<vector<int>>& adjlist, int cur, int par, int seats) {
        // spawn children 
        vector<long long> ret = {1, 0}; 
        
        // leaf 
        if(adjlist[cur].size() == 1 && adjlist[cur][0] == par) return {1, 1}; 

        // visit children 
        for(int n : adjlist[cur]) {
            if(n == par) continue; 
            vector<long long> nret = dfs(adjlist, n, cur, seats); 
            ret[0] += nret[0]; 
            ret[1] += nret[1]; 
        }

        // modify number of cars 
        if(cur != 0) ret[1] += ceil((1.0*ret[0])/seats); 
        return ret; 
    }


    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        int n = 0; 
        for(vector<int>& r : roads) n = max(r[0], max(n, r[1])); 
        n++; 

        // recursion that passes 2 up 
        vector<vector<int>> adjlist = vector(n, vector(0, 0)); 
        for(vector<int>& r : roads) {
            adjlist[r[0]].push_back(r[1]);
            adjlist[r[1]].push_back(r[0]);
        }

        // call dfs 
        return dfs(adjlist, 0, -1, seats)[1]; 
    }
};
