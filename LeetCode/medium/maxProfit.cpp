class Solution {
public:
    int maxProfit(vector<int>& prices) {
        //every single increasing sub sequence
        int ret = 0; 
        bool bought = false; 
        int buyPrice = -1; 
        prices.push_back(-1); //get it to consider the last case 
        for(long i = 0; i < prices.size()-1; i++) {
            if(prices[i+1] > prices[i] && bought == false) {
                bought = true; 
                buyPrice = prices[i]; 
            }
            else if(prices[i+1] < prices[i] && bought == true) {
                bought = false; 
                ret += prices[i] - buyPrice; 
            }
        }
            
        return ret; 
    }
};
