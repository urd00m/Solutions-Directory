class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        vector<int> dp = vector(101, 0);
        int ret = 0; 
        for(int i : nums) 
            ret += dp[i]++;
        return ret;
    }
};
