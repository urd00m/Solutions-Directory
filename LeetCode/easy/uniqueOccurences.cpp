class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        map<int, int> occ; 
        for(int val : arr) {
            if(occ.find(val) == occ.end()) 
                occ[val] = 0;
            occ[val]++; 
        }

        // check 
        unordered_set<int> visited; 
        for(const auto& [key, val] : occ) {
            if(visited.find(val) != visited.end())
                return false; 
            visited.insert(val);
        }
        return true; 
    }
};
