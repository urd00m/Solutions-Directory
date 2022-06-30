class Solution {
public:
    int minMoves2(vector<int>& nums) {
        sort(nums.begin(), nums.end()); 
        int select = nums[nums.size()/2]; //select median 
        
        // calculate additions 
        int ret = 0;
        for(int i = 0; i < nums.size(); i++) 
            ret += abs(select - nums[i]);
        return ret; 
    }
};
