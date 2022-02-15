class Solution {
public:
    int singleNumber(vector<int>& nums) {
        unordered_set<int> exists; 
        
        for(int item : nums) {
            if(exists.find(item) != exists.end()) {
                exists.erase(item);
            }
            else {
                exists.insert(item);
            }
        }
        return *(exists.begin()); 
        
        
    }
};
