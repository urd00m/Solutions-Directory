class Solution {
public:
    // recur
    int recur(vector<vector<pair<int,int>>>& adjlist, vector<int>& v, int c) {
        if(v[c]) return INT32_MAX;  
        v[c] = 1; 
        int ret = INT32_MAX;
        for(pair<int, int>& n : adjlist[c])
            ret = min(ret, min(n.first, recur(adjlist, v, n.second))); 
        return ret; 
    }

    int minScore(int n, vector<vector<int>>& roads) {
        // this is literally just dijstrika's algorithm 
        // convert to adjlist 
        vector<vector<pair<int,int>>> adjlist = vector(n, vector<pair<int,int>>(0, {0, 0}));
        for(vector<int>& r : roads) {
            adjlist[r[0]-1].push_back({r[2], r[1]-1}); // {dist, dest}
            adjlist[r[1]-1].push_back({r[2], r[0]-1});
        }
        vector<int> v = vector(n, 0); 
        return recur(adjlist, v, 0); 
    }
};
