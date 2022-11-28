class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        // maintain mapping
        vector<int> unique; 
        unordered_map<int, int> m; 

        // iteratate 
        for(vector<int>& match : matches) {
            // for winner
            if(m.find(match[0]) == m.end()) {
                unique.push_back(match[0]); 
                m[match[0]] = 0; 
            }
            
            // for loser
            if(m.find(match[1]) == m.end()) {
                unique.push_back(match[1]);
                m[match[1]] = 0; 
            }

            // update loser
            m[match[1]]++; 
        }

        // iterate for answer
        vector<vector<int>> ret = vector(2, vector(0, 0)); 
        for(int u : unique) {
            if(m[u] == 0) ret[0].push_back(u); 
            else if(m[u] == 1) ret[1].push_back(u); 
        }
        sort(ret[0].begin(), ret[0].end());
        sort(ret[1].begin(), ret[1].end());
        return ret; 
    }
};
