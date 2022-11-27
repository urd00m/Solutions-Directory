class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        // dp 
        // 7 7 7 7 7
        // 0

        // 0: {}
        // 1: {0: 1}
        // 2: {0: 1}

        long n = nums.size(); 
        vector<unordered_map<long, int>> dp = vector(n, unordered_map<long,int>()); 
        
        int ret = 0; 
        for(int i = 1; i < n; i++) {
            for(int j = i-1; j >= 0; j--) {
                // update current entry 
                long diff = (long)nums[i] - (long)nums[j]; 
                if(dp[i].find(diff) == dp[i].end()) dp[i][diff] = 0; 
                dp[i][diff] += 1; 

                // determine if we can add any 
                if(dp[j].find(diff) != dp[j].end()) {
                    ret += dp[j][diff]; 
                    dp[i][diff] += dp[j][diff]; 
                }
            }
        }
        return ret; 
    }
};
