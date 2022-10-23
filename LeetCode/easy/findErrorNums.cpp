class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        vector<int> visited = vector(nums.size()+1, 0); 
        for(int num : nums) visited[num]++; 
        
        
        int doubled = -1; 
        int missing = -1;
        for(int i = 1; i < nums.size()+1; i++) {
            if(visited[i] == 2) doubled = i; 
            if(visited[i] == 0) missing = i; 
        }
        
        return {doubled, missing}; 
    }
};
