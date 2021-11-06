class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        unordered_map<int, int> counts; 
        for(int item : nums) {
            if(counts.find(item) == counts.end()) counts[item] = 1;
            else counts[item]++; 
        }
        
        //iteration 
        vector<int> ret; 
        for(int item : nums) {
           if(counts[item] == 1) ret.push_back(item);
        }
        
        return ret; 
    }
};
