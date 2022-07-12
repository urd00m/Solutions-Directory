class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buy_cost = INT32_MAX; 
        int ret = 0; 
        for(long i = 0; i < prices.size(); i++) {
            ret = max(ret, prices[i]-buy_cost); //take the min as we go 
            buy_cost = min(buy_cost, prices[i]); 
        }
        return ret; 
    }
};
