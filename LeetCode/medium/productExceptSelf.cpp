class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        //prefix 
        vector<int> prefix(nums.size()+1, 0); //use indexing starting from 1 
        vector<int> postfix(nums.size()+2, 0); 
        long product = 1; prefix[0] = product; 
        for(long i = 1; i <= nums.size(); i++) {
            product *= nums[i-1]; 
            prefix[i] = product; 
        }
        product = 1; postfix[nums.size()+1] = 1; 
        for(long i = nums.size(); i >= 1; i--) {
            product *= nums[i-1]; 
            postfix[i] = product; 
        }
        vector<int> ret; 
        for(long i = 1; i <= nums.size(); i++) {
            ret.push_back(prefix[i-1]*postfix[i+1]); 
        }
        
        return ret; 
    }
};
