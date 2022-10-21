class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        // map  
        unordered_map<int, vector<int>> dist; // stores index for most recent number
        for(int i = 0; i < nums.size(); i++) {
            if(dist.find(nums[i]) == dist.end()) dist[nums[i]] = vector(0, 0);
            else { // check distances
                vector<int> indexes = dist[nums[i]]; 
                for(int idx : indexes) if( abs(idx-i) <= k) return true;
            }
            dist[nums[i]].push_back(i); 
        }
        return false; 
    }
};
