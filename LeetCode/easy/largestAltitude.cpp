class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        // running max 
        int ret = 0;
        int cur = 0; 
        for(int g : gain) {
            cur += g; 
            ret = max(cur, ret);
        }
        return ret; 
    }
};
