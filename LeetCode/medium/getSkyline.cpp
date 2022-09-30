class Solution {
public:
    
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        // use map to store indexes 
        map<int, vector<int>> houses; 
        multiset<int> heights; 
        
        // set up our indexes
        for(int i = 0; i < buildings.size(); i++) {
            houses[buildings[i][0]].push_back(buildings[i][2]);
            houses[buildings[i][1]].push_back(-buildings[i][2]);
        }
        
        // iterate 
        vector<vector<int>> ret;
        for(auto& [idx, house_changes] : houses) { 
            for(int i = 0; i < house_changes.size(); i++) {
                if(house_changes[i] > 0) {
                    heights.insert(house_changes[i]); 
                }
                else { // remove it 
                    heights.erase(heights.lower_bound(-house_changes[i])); 
                }
            }
            

            // find max height 
            int ans = heights.empty() ? 0 : *heights.rbegin(); 
            if(ret.empty() || (ret.back()[1] != ans)) 
               ret.push_back({idx, ans}); 
        }
                   
        return ret; 
    }
};
