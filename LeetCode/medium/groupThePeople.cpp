class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        vector<vector<int>> ret; 
        unordered_map<int, vector<int>> m;
        for(int i = 0; i < groupSizes.size(); i++) {
            if(m.find(groupSizes[i]) == m.end())
                m[groupSizes[i]] = vector<int>(0, 0); 
            
            // add and if reached max size pushback 
            m[groupSizes[i]].push_back(i);
            if(m[groupSizes[i]].size() == groupSizes[i]) {
                ret.push_back(m[groupSizes[i]]);
                m[groupSizes[i]] = vector<int>(0, 0); 
            }
        }
        return ret; 
    }
};
