class Solution {
public:
    size_t position(vector<int>& potions, long long find) {
        size_t l = 0, r = potions.size(); 
        while(l < r) {
            size_t m = (l+r)/2; 

            // if(potions[m] == find) r = m; 
            if(potions[m] < find) l = m+1; 
            else r = m; 
        }
        return l;
    }

    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        // can do a nlogn solution by sorting
        // sort 
        sort(potions.begin(), potions.end()); 

        // iterate through
        size_t n = spells.size(); 
        size_t m = potions.size(); 
        vector<int> ret = vector(n, 0); 
        for(size_t i = 0; i < n; i++) {
            long long potion_strength_needed = ceil( (success * 1.0) / spells[i]);
            size_t position_needed = position(potions, potion_strength_needed); 
            ret[i] = m - position_needed; 
        }
        return ret; 
    }   
};
