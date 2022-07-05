class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int ret = 0; 
        
        unordered_map<int, int> visited; 
        
        // set up set 
        for(int num : nums) 
            visited[num] = 1; 
            //visited.insert(num); 

        //unordered_set<int> visited(nums.begin(), nums.end()); 
        
        // iterate 
        for(int num : nums) {
            if(visited.find(num-1) == visited.end()) { //not in visited 
                int seq = 0; 
                while(visited.find(num) != visited.end()) {
                    num++; 
                    seq++; 
                }
                ret = max(ret, seq); 
            }
        }
        
        return ret; 
    }
};
