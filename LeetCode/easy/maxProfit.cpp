class Solution {
public:
    int maxProfit(vector<int>& prices) {
        long left = 0, right = 1; 
        int max = 0; 
        while(right < prices.size()) {
            int profit = prices[right] - prices[left]; 
            if(profit < 0) {
                left = right;
            } else {
                max = profit > max ? profit : max; 
            }
            right++; 
        }
        
        return max; 
    }
};
