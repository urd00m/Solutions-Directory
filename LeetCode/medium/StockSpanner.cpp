class StockSpanner {
public:
    vector<int> nums; 
    vector<int> dp; 
    StockSpanner() {
        nums.clear(); 
        dp.clear(); 
    }
    
    int next(int price) {
        int ret = 1; 
        int idx = nums.size()-1; 
        nums.push_back(price);
        while(idx >= 0 && price >= nums[idx]) {
            ret += dp[idx]; 
            idx -= dp[idx];
        }
        dp.push_back(ret);
        return ret; 
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */
