class Solution {
public:
    int majorityElement(vector<int>& nums) {
        long n = nums.size();
        long m = n/2 + 1; // > majority element 
        
        unordered_map<int, int> exists; 
        for(int item : nums) {
            if(exists.find(item) == exists.end()) 
                exists[item] = 0;
            if(++exists[item] == m) return item; 
        }
        return -1; //should never be ran 
    }
};
