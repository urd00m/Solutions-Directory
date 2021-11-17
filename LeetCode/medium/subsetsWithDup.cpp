class Solution {
public:
    
    string convert(vector<int> a) {
        string ret = ""; 
        for(int item : a) {
            ret += to_string(item) + ","; 
        }
        return ret; 
    }
    
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        
        long n = nums.size(); 
        //bitmask  
        unsigned long size = 1<<nums.size(); 
        vector<vector<int>> ret; 
        for(unsigned long mask = 0; mask < size; mask++) {
            vector<int> add; 
            for(unsigned long i = 0; i < n; i++) {
                if(1<<i & mask) add.push_back(nums[i]); 
            }
            ret.push_back(add); 
        }
            
        //remove duplicates
        vector<vector<int>> pruned; 
        unordered_map<string, bool> visited; 
        for(long i = 0; i < ret.size(); i++) {
            if(visited.find(convert(ret[i])) == visited.end()) {
                visited[convert(ret[i])] = false; 
            }
            if(visited[convert(ret[i])] == false) {
                pruned.push_back(ret[i]); 
                visited[convert(ret[i])] = true; 
            }
        }
        
        return pruned; 
    }
};
