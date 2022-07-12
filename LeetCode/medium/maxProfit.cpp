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

/*
//second pass around code
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        // buy at lows sell at peaks 
        int ret = 0; 
        int low = prices[0]; 
        int high = prices[0]; 
        for(long i = 1; i < prices.size(); i++) {
            if(prices[i] < high) { // sell now 
                ret += high - low; 
                high = prices[i]; 
                low = prices[i]; 
            }
            if(prices[i] > high) { // buy it 
                high = prices[i]; 
            }
        }
        ret += high-low; 
        return ret; 
    }
};
*/
