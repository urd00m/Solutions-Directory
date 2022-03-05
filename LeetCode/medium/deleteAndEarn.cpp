class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        //map 
        vector<long> map(20001, 0); 
        for(int num : nums) {
            map[num]++; // update 
        }
        
        //dp 
        vector<long> dp(20003, 0); 
        for(long i = 0 ; i < 20001; i++) {
            
            dp[i+1] = max(dp[i+1], dp[i]);  // don't accept 
            if(map[i] != 0) {
                dp[i+2] = max(dp[i+2], dp[i] + map[i]*i);  // accept 
            }
        }
        return max(dp[20002], dp[20001]); 
    }
};
