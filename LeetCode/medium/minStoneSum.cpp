class Solution {
public:
    int minStoneSum(vector<int>& piles, int k) {
        // apply to the maximum pile 
        // priority queue (max heap)
        int ret = 0; 
        priority_queue<int> p;
        for(int item : piles) {
            p.push(item); 
            ret += item; 
        }

        // begin algorithm 
        // more efficient algorithm is to remove from the top and only add it back once it is less than the second highest max, but a little more code is required so going with less efficient but simplier solution
        while(k > 0) {
            int cur = p.top(); p.pop(); 
            int remove = (int)floor(cur/2.0); 
            ret -= remove; 
            p.push(cur - remove); 
            k--; 
        }
        return ret; 
    }
};
