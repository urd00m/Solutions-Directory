class Solution {
public:
    vector<int> sumEvenAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        vector<int> ret; 
        
        // calculate initial sum now 
        int sum = 0; 
        for(int item : nums) 
            if(item % 2 == 0)
                sum += item; 
        
        // do queries
        for(vector<int> query : queries) {
            int cur = nums[query[1]]; 
            if(cur % 2 == 0)  // if even we have to subtract
                sum -= cur; 
            cur += query[0]; 
            
            // Update
            if(cur % 2 == 0) 
                sum += cur;
            nums[query[1]] = cur; 
                
            ret.push_back(sum);
        }
        
        return ret; 
    }
};
