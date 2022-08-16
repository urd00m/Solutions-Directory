#define MAX 100000
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        // dp - represents the minimum number of tries to reach that amount 
        // this problem would be trickier if you did not have an infinite number of each kind of coin (I'm guessing this is coin change 2, if so you just use a 2D dp array, state where you also say you've used up to j coins to reach i amount)
        vector<int> dp = vector(amount+1, MAX); 
        dp[0] = 0; 
        
        // update 
        for(long i = 0; i < amount; i++) {
            for(int coin : coins) {
                if(i + coin <= amount) {
                    // either this coin makes it faster or not 
                    dp[i + coin] = min(dp[i + coin], dp[i] + 1); 
                }
            }
        }
        
        // ret
        if(dp[amount] == MAX) return -1; 
        else return dp[amount]; 
    }
};

// took <5 mins
