class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> sums; //sum to count 
        vector<int> prefix_sums; 
        int sum = 0; 
        
        // prefix sum
        for(long i = 0; i < nums.size(); i++) {
            sum += nums[i];
            prefix_sums.push_back(sum); 
        }
        
        // iterate through the prefix sums to find match 
        int ret = 0; 
        for(long i = 0; i < prefix_sums.size(); i++) {
            if(prefix_sums[i] == k)
                ret++; 
            
            if(sums.find(prefix_sums[i] - k) != sums.end()) 
                ret += sums[prefix_sums[i] - k];
            
            if(sums.find(prefix_sums[i]) == sums.end()) 
                sums[prefix_sums[i]] = 0;
            
            sums[prefix_sums[i]]++;     
        }
        
        return ret; 
    }
};
