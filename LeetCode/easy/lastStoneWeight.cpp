class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        if(stones.size() == 0) return 0; 
        sort(stones.begin(), stones.end()); 
        reverse(stones.begin(), stones.end());
        // keep smashing
        while(stones.size() > 1) {
            int next = max(stones[0], stones[1]) - min(stones[0], stones[1]);
            stones.erase(stones.begin());
            stones.erase(stones.begin());
            stones.push_back(next);
            sort(stones.begin(), stones.end()); 
            reverse(stones.begin(), stones.end());
        }
        return stones.size() == 0 ? 0 : stones[0]; 
    }
};
