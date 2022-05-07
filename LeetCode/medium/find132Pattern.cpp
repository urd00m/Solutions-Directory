class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        stack<int> r; 
        int between = INT32_MIN;
        
        for(long i = nums.size()-1; i >= 0; i--) {
            if(nums[i] < between)
                return true;
        
            while(!r.empty() && nums[i] > r.top()) {
                between = r.top(); // guarenteed to be the max 
                r.pop(); 
            }
            r.push(nums[i]);
        }
        
        return false; 
    }
};
