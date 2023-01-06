class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        // is this really a medium? 
        // sort in decreasing order 
            // possible optimization since coin value is only 10^5 it could be faster to just store a array reprsenting the number of coins for that value and iterate through that instead 
        // then just select the smallest costs until you run out of coins 
        sort(costs.begin(), costs.end()); 

        int ret = 0; 
        int i = 0; 
        while(i < costs.size()) {
            if(costs[i] > coins) break; 
            coins -= costs[i++]; 
            ret++; 
        }
        return ret; 
    }
};
