class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        if(changed.size() % 2)  return {}; // can't be a doubled array if it has odd size 
        
        // sort
        sort(changed.begin(), changed.end()); 
        
        // count zero (edge case)
        /*
        int i = 0; 
        while(changed[i] == 0) i++; 
        
        // i must be even
        if(i % 2) return {}; 
        */
        
        // assemble original array 
        int new_size = changed.size()/2; 
        vector<int> orig; 
        
        // check squares 
        unordered_map<int, int> map; //  double we are looking for and how many are looking for it
        for(int i = 0; i < changed.size(); i++) {
            if(map.find(changed[i]) == map.end() || map[changed[i]] == 0) {
                if(map.find(changed[i]*2) == map.end())
                       map[changed[i] * 2] = 0; 
                map[changed[i] * 2]++;
            }
            else {
                map[changed[i]]--; 
                orig.push_back(changed[i]/2); 
            }
        }
        
        if(orig.size() != new_size) return {}; // didn't all match up 
        return orig; 
    }
};
