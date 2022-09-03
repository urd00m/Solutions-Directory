class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<int> dp = vector<int>(amount+1, 0); 
        dp[0] = 1; 
        
        // order does not matter 
        for(int coin : coins) {
            for(int i = 0; i < amount+1; i++) {
                if(i + coin <= amount) {
                    dp[i + coin] += dp[i]; 
                }
            }
        }
        
        return dp[amount]; 
    }
};
