class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum = 0; 
        for(int item : nums) sum += item; 
        if(sum%2==1) return false; 
        
        //find mid 
        int mid = sum/2; 
        
        //dp 
        vector<long> dp(mid+1, 0);
        dp[0] = 1; 
        int count = 0;
        for(int item : nums) {
            vector<long> temp = dp; 
            for(long i = 0; i < mid+1; i++) {
                if(i + item < mid+1) {
                    temp[i+item] = temp[i+item] | (dp[i] > 0 ? 1 : 0); 
                } 
            }
            dp = temp; 
        }
        
        //output
        if(dp[mid] > 0) return true;
        else return false; 
    }
};
