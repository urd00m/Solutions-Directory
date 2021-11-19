class Solution {
public:
    int hammingDistance(int x, int y) {
        int ret = 0; 
        for(int i = 0; i < 32; i++) {
            int bitx = x&(1<<i);
            int bity = y&(1<<i);
            if(bitx^bity) ret++;
        }
        return ret; 
    }
};
