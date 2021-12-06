class Solution {
public:
    int minCostToMoveChips(vector<int>& position) {
        //just calculate two different positions 
        if(position.size() == 1) return 0; 
    
        int ret = INT32_MAX; 
        
        //for position 0 
        for(long i = 0; i < position.size(); i++) {
            int cost = 0; 
            for(long j = 0; j < position.size(); j++) {
                if(abs(position[i]-position[j])%2 == 1) { //not a distance of 2 away 
                    cost += 1; 
                }
            }
            ret = min(ret, cost); 
        }
        
        return ret; 
    }
};
