class Solution {
public:
    vector<int> restoreArray(vector<vector<int>>& adjacentPairs) {
        // create linkedlist, use map
        vector<int> ret; 
        unordered_map<int, vector<int>> m; 
        
        // assemble 
        for(vector<int>& p : adjacentPairs) {
            if(m.find(p[0]) == m.end()) m[p[0]] = vector<int>(0); 
            if(m.find(p[1]) == m.end()) m[p[1]] = vector<int>(0); 
            m[p[0]].push_back(p[1]);
            m[p[1]].push_back(p[0]);
        }

        // find start of the
        int start; 
        for(auto& [a, b] : m) 
            if(b.size() == 1) {
                start = a; 
                break; 
            }

        // create ret 
        int cur = start; 
        unordered_set<int> v; 
        while(true) {
            v.insert(cur); 
            ret.push_back(cur); 
            bool still_more = false; 
            for(int next : m[cur])
                if(v.find(next) == v.end()) {
                    cur = next; 
                    still_more = true; 
                }
            if(!still_more) break; 
        }
        return ret; 
    }
};
