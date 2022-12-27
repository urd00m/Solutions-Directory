class Solution {
public:
    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        // sort by difference and count 
        vector<int> diff; 
        for(int i = 0; i < capacity.size(); i++) 
            diff.push_back(capacity[i] - rocks[i]); 

        // ascending order 
        sort(diff.begin(), diff.end()); 

        // count
        int ret = 0; 
        for(int i = 0; i < diff.size(); i++) {
            if(diff[i] > additionalRocks) break; 
            ret++; 
            additionalRocks -= diff[i]; 
        }
        return ret; 
    }
};

// 2 minute solve
