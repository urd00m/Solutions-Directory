class Solution {
public:
    int hammingWeight(uint32_t n) {
        int ret = 0;
        for(int i = 0; i < 32; i++) {
            ret += n&(1<<i) ? 1 : 0;
        }
        return ret; 
    }
};
