class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        // pq 
        priority_queue<pair<int,int>> pq; 

        // add 
        int l = 0; 
        int r = costs.size()-1; 
        for(int i = 0; i < min((int)(1+costs.size())/2, candidates); i++) {
            pq.push({-1*costs[l], -1*l++}); 
            if(l <= r) pq.push({-1*costs[r], -1*r--}); 
        }

        // begin summing up costs
        long long ret = 0; 
        for(int i = 0; i < k; i++) {
            // select min 
            pair<int,int> c = pq.top(); pq.pop(); 
            ret += -1*c.first; 

            // add another back 
            if(l <= r) {
                if(-1*c.second < l) pq.push({-1*costs[l], -1*l++}); 
                else pq.push({-1*costs[r], -1*r--});   
            }
        }

        return ret; 
    }
};
