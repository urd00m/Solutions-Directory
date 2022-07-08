#define MAX 100000007
class Solution {
public:
    int jump(vector<int>& nums) {
        //dfs with memoization 
        // dp[i] is the minimum jumps needed to reach the ith position 
        vector<int> dp = vector(nums.size(), MAX);
        dp[0] = MAX; 
        
        int ret = dfs(nums, dp, 0); 
        return ret; 
    }
    int dfs(vector<int>& nums, vector<int>& dp, int cur) {
        if(cur >= nums.size()-1) return 0;  //we made it 
        
        if(dp[cur] != MAX) return dp[cur];
        
        int ret = MAX;
        for(int i = cur+nums[cur]; i > cur; i--) 
            ret = min(dfs(nums, dp, i)+1, ret);
        return dp[cur] = ret;    
    }
};

// faster than the dpq solution because it doesn't incur the overhead of the priority queue 
