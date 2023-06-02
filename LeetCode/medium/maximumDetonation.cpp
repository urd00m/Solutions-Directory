class Solution {
public:
    double dist(int a, int b, int c, int d) {
        return sqrt(((long)a-b)*((long)a-b) + ((long)c-d)*((long)c-d)); 
    }

    int reach(vector<vector<int>>& adjlist, vector<int>& v, int idx) {
        if(v[idx]) return 0; 
        int ret = 1; 
        v[idx] = 1; 
        for(int n : adjlist[idx]) {
            ret += reach(adjlist, v, n); 
        }
        return ret; 
    }

    int maximumDetonation(vector<vector<int>>& bombs) {
        // construct graph 
        size_t n = bombs.size(); 
        vector<vector<int>> adjlist = vector(n, vector(0, 0)); 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue; 
                vector<int>& b = bombs[i]; 
                vector<int>& b2 = bombs[j]; 
                double d = dist(b[0], b2[0], b[1], b2[1]); 
                if(d <= b[2]) 
                    adjlist[i].push_back(j); 
            }
        }

        // find reach from each bomb 
        int ret = 0; 
        for(int i = 0; i < n; i++) {
            vector<int> v = vector(n, 0); 
            ret = max(ret, reach(adjlist, v, i)); 
        }
        return ret; 
    }
};
